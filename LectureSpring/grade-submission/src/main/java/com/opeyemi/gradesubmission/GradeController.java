package com.opeyemi.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    studentGrades.add(grade);
    return "redirect:/grade";
  }

  @GetMapping("/grade")
  public String getGrades(Model model){
    model.addAttribute("grade", studentGrades);
    return "grades";
  }

  public Integer getGradeIndex(String name){
    for(int i = 0; i < studentGrades.size(); i++){
      if(studentGrades.get(i).getName().equals(name)) return i;    
    }
    return -1000;
  }

  @GetMapping(value = "/view")
  public String getMethodValue(Model model){
    model.addAttribute("menu", "we sell chocolate rice cakes bubble tea");
    return "view";
  }

  @GetMapping(value = "/")
  public String gradeForm(Model model, @RequestParam(required = false) String name){
    model.addAttribute("grade", getGradeIndex(name) == -1000 ? new Grade() : studentGrades.get(getGradeIndex(name)));
    return "form";
  }

}
