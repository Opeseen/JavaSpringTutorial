package com.opeyemi.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.opeyemi.banking.entity.Transactions;
import com.opeyemi.banking.entity.User;
import com.opeyemi.banking.helpers.TransactionRequest;
import com.opeyemi.banking.helpers.UserSetup;
import com.opeyemi.banking.services.UserService;
import com.opeyemi.banking.validators.Constants;

import java.util.*;

import jakarta.validation.Valid;
import lombok.*;
@AllArgsConstructor


@Controller
public class UserController {
  UserService userService;

  @GetMapping("/")
  public String WelcomePage(Model model){
    return "homepage";
  }
  @GetMapping("user/signup")
  public String UserForm(Model model){
    model.addAttribute("userSetup", new UserSetup());
    return "sign-up";
  }

  // Controller to register user
  @PostMapping("user/register")
  public String registrationHandler(@Valid UserSetup userSetup, BindingResult result, RedirectAttributes redirectAttributes){
    if(!userSetup.getPassword().equals(userSetup.getConfirmPassword())) result.rejectValue("confirmPassword", "", "Password do not match");
    if (result.hasErrors()) return "sign-up";
    if(userService.createUser(userSetup)){
      redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
      return "redirect:/user/signup";
    }else{
      redirectAttributes.addFlashAttribute("status", Constants.USER_ALREADY_EXISTS);
      return "redirect:/user/signup";
    }  
  }

  // Controller to navigate to the login page
  @GetMapping("user/login")
  public String loginPage(User user, Model model){
    model.addAttribute("user", new User());
    return "login";
  }

  // Controller to handle user login credentials
  @PostMapping("user/submitLoginDetails")
  public String loginhandler(User user, Model model, RedirectAttributes redirectAttributes){
    User userConfirmation = userService.confirmLoginDetails(user.getUsername(), user.getPassword());
    if(userConfirmation != null){
      model.addAttribute("user", userConfirmation);
      redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
      return "redirect:/user/"+ userConfirmation.getId() + "/dashboard";
    }else{
      redirectAttributes.addFlashAttribute("status", Constants.FAILED_STATUS);
      return "redirect:/user/login";
    }
  }
  // Handler to shou the User dashboard
  @GetMapping("user/{Id}/dashboard")
  public String dashboardPage(User user, Model model, @PathVariable(required = false) Long Id){
    // If user id not found - return empty - else return the user details
    model.addAttribute("user", userService.fetchUser(Id) == null ? new User() : userService.fetchUser(Id));
    return "userDashboard";
    
  }

  // Handler to navigate to the ucer to credit/debit account request page 
  @GetMapping("user/{Id}/transaction/request")
  public String transactionRequestPage(Model model, @PathVariable Long Id, @RequestParam(required = false) String type){
    User user = userService.fetchUser(Id);
    if(type.equals("debit")){
      model.addAttribute("transactionRequest", new TransactionRequest());
      model.addAttribute("user", user);
      return "initiateDebitTransactions";
    }
    if(type.equals("credit")){
      model.addAttribute("transactionRequest", new TransactionRequest());
      model.addAttribute("user", user);
      return "initiateCreditTransactions"; 
    }
    return "result";
  }

  // Handler to submit the user credit request
  @PostMapping("user/{Id}/transaction/credit/submit")
  public String submitCreditRequest(@Valid TransactionRequest transactionRequest, BindingResult result, Model model, @PathVariable(required = false) String Id, RedirectAttributes redirectAttributes){
    if (result.hasErrors()) {return "initiateCreditTransactions";}
    if(userService.processCreditTransaction(transactionRequest, Id) != null){
      return "redirect:/user/" + Id + "/dashboard";
    }else{
      redirectAttributes.addFlashAttribute("status", Constants.FAILED_STATUS);
      return "redirect:/user/" + Id + "/transaction/request";
    }  
    
  }

  // Handler to submit the user debit request
  @PostMapping("user/{Id}/transaction/debit/submit")
  public String submitDebitRequest(@Valid TransactionRequest transactionRequest, BindingResult result, Model model, @PathVariable(required = false) String Id, RedirectAttributes redirectAttributes){
    if (result.hasErrors()) {return "initiateDebitTransactions";}
    Boolean DebitTransactionRequest = userService.processDebitTransaction(transactionRequest, Id);
    if(DebitTransactionRequest == false){
      redirectAttributes.addFlashAttribute("status", Constants.INSUFFICIENT_FUND);
      return "redirect:/user/" + Id + "/transaction/request?type=debit";
    } else {
      return "redirect:/user/" + Id + "/dashboard";
    }

    
  }

  // Handler to display user list of transactions history
  @GetMapping("user/{Id}/transaction/history")
  public String showUserTransactions(Model model, @PathVariable String Id){
    List<Transactions> userTransactions = userService.getUserTransactionHistory(Id);
    User user = userService.fetchUser(Long.parseLong(Id));
    // If no list of transactions found - display an enpty list 
    if(userTransactions.isEmpty()){
      model.addAttribute("transactions", new Transactions());
      model.addAttribute("user", user);
      return "transactions";
    }else{
      // Map the list of transaction to the model for thymleaf to process it.
      model.addAttribute("user", user);
      model.addAttribute("transactions", userTransactions);
      return "transactions";
    }
    
  }

}
