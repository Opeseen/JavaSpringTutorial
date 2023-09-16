package com.opeyemi.globalsuperstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SuperstoreController {
    List<Item> items = new ArrayList<>();
    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id){
        int index = getIndexFormId(id);
        model.addAttribute("item", index == Constants.NOT_FOUND ? new Item() : items.get(index));
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model){
        model.addAttribute("Inventory", items);
        
        return "inventory";
    }
    
    @PostMapping("/submitItem")
    public String submitInventory(Item item, RedirectAttributes redirectAttributes){
        int index = getIndexFormId(item.getId());
        String status = Constants.SUCCESS_STATUS;
        if(index == Constants.NOT_FOUND) {
            items.add(item);
        }else if(within5Daye(item.getDate(), items.get(index).getDate())){
            items.set(index, item);
        }else {
            status = Constants.FAILED_STATUS;
        }
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";
    }

    public int getIndexFormId(String id){
        for(int x = 0; x < items.size(); x++){
            if(items.get(x).getId().equals(id)) return x;
        }
        return Constants.NOT_FOUND;
    }

    public boolean within5Daye(Date newDate, Date oldDate){
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        System.out.println(newDate + " " + oldDate);
        System.out.println(diff);
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }
}
