package com.opeyemi.globalsuperstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SuperstoreController {
    List<Item> items = new ArrayList<>();
    @GetMapping("/")
    public String getForm(Model model){
        model.addAttribute("categories", Constants.CATEGORIES);
        model.addAttribute("item", new Item());
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model){
        model.addAttribute("Inventory", items);
        
        return "inventory";
    }
    
    @PostMapping("/submitItem")
    public String submitInventory(Item item){
        items.add(item);
        System.out.println(items);
        return "redirect:/inventory";
    }
}
