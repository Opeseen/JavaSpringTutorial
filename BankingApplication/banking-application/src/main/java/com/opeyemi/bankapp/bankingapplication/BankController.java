package com.opeyemi.bankapp.bankingapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {
    @GetMapping("/")
    public String CreateAccount(Model model){
        model.addAttribute("bank", new Bank());
        return "form";
    }
}
