package com.opeyemi.fieldvalidation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;


@Controller
public class GradeController {
  List<Grade> studentGrades = new ArrayList<>();
  
  @GetMapping("/conditionals")
  public String getMethodName(Model model){
    model.addAttribute("sale",150);
    model.addAttribute("sales",50);
    model.addAttribute("product", "table");
    return "conditionals";
  }

  @PostMapping("/handleSubmit")
  public String SubmitForm(@Valid Grade grade, BindingResult result, RedirectAttributes redirectAttributes ){
    String status = Constant.SUCCESS_STATUS;
    if (result.hasErrors()) return "form";
    int index = getGradeIndex(grade.getId());
    if (index == Constant.NOT_FOUND){
      studentGrades.add(grade);
      redirectAttributes.addFlashAttribute("status", status);
    }else{
      status = Constant.UPDATE_STATUS;
      studentGrades.set(index,grade);
      redirectAttributes.addFlashAttribute("status", status);
    }
   
    return "redirect:/grade";
  }

  @GetMapping("/grade")
  public String getGrades(Model model){
    model.addAttribute("grade", studentGrades);
    return "grades";
  }

  public int getGradeIndex(String id){
    for(int i = 0; i < studentGrades.size(); i++){
      if(studentGrades.get(i).getId().equals(id)) return i;    
    }
    return Constant.NOT_FOUND;
  }

  @GetMapping(value = "/view")
  public String getMethodValue(Model model){
    model.addAttribute("menu", "we sell chocolate rice cakes bubble tea");
    return "view";
  }

  @GetMapping(value = "/")
  public String gradeForm(Model model, @RequestParam(required = false) String id){
    int index = getGradeIndex(id);
    model.addAttribute("grade", index == Constant.NOT_FOUND ? new Grade() : studentGrades.get(index));
    return "form";
  }

}
