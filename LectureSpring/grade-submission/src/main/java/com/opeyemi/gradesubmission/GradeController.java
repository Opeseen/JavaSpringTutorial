package com.opeyemi.gradesubmission;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GradeController {
  List<Grade> studentGrades = Arrays.asList(
    new Grade("Harry","Maths","C-"),
    new Grade("Mike","English","A-"),
    new Grade("John","Econs","B+")
  );
  
  @GetMapping("/conditionals")
  public String getMethodName(Model model){
    model.addAttribute("sale",150);
    model.addAttribute("sales",50);
    model.addAttribute("product", "table");
    return "conditionals";
  }

  @GetMapping("/grade")
  public String getGrades(Model model){
    model.addAttribute("grade", studentGrades);
    return "grades";
  }

  @GetMapping(value = "/")
  public String getMethodValue(Model model){
    model.addAttribute("menu", "we sell chocolate rice cakes bubble tea");
    return "view";
  }
}
