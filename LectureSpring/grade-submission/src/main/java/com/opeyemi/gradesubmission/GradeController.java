package com.opeyemi.gradesubmission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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
  public String SubmitForm(Grade grade){
    System.out.println(grade);
    studentGrades.add(grade);
    return "redirect:/grade";
  }

  @GetMapping("/grade")
  public String getGrades(Model model){
    model.addAttribute("grade", studentGrades);
    return "grades";
  }

  @GetMapping(value = "/view")
  public String getMethodValue(Model model){
    model.addAttribute("menu", "we sell chocolate rice cakes bubble tea");
    return "view";
  }

  @GetMapping(value = "/")
  public String gradeForm(Model model){
    model.addAttribute("grade", new Grade());
    return "form";
  }

}
