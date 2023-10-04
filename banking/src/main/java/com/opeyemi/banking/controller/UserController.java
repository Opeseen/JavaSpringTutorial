package com.opeyemi.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.opeyemi.banking.entity.User;
import com.opeyemi.banking.entity.UserSetup;
import com.opeyemi.banking.services.UserService;
import com.opeyemi.banking.validators.Constants;

import jakarta.validation.Valid;
import lombok.*;
@AllArgsConstructor
@Controller

@RequestMapping("/user")
public class UserController {
  UserService userService;

  @GetMapping("/signup")
  public String UserForm(Model model){
    model.addAttribute("userSetup", new UserSetup());
    return "sign-up";
  }

  // Controller to register user
  @PostMapping("/register")
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
  @GetMapping("/login")
  public String loginPage(User user, Model model){
    model.addAttribute("user", new User());
    return "login";
  }

  // Controller to handle user login credentials
  @PostMapping("/submitLoginDetails")
  public String loginhandler(User user, Model model, RedirectAttributes redirectAttributes){
    User userConfirmation = userService.confirmLoginDetails(user.getUsername(), user.getPassword());
    if(userConfirmation != null){
      model.addAttribute("user", userConfirmation);
      redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
      return "redirect:/dashboard/" + userConfirmation.getId();
    }else{
      redirectAttributes.addFlashAttribute("status", Constants.FAILED_STATUS);
      return "redirect:/login";
    }
  }

  @GetMapping("/dashboard/{Id}")
  public String dashboardPage(User user, Model model, @PathVariable(required = false) Long Id){
    // If user id not found - return empty - else return the user details
    model.addAttribute("user", userService.fetchUser(Id) == null ? new User() : userService.fetchUser(Id));
    return "userDetails";
    
  }

}
