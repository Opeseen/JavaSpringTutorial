package com.opeyemi.fieldvalidationone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class UserController {
    List<User> userList = new ArrayList<>();
    @GetMapping("/")
    public String UserForm(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid User user, BindingResult result){
        if(user.getFirstName().equals(user.getLastName())) result.rejectValue("lastName","","First Name and Last Name can't be the same");
        if (result.hasErrors()) return "sign-up";  
        userList.add(user);
        System.out.println(user);
 
        return "result";
    }
}

