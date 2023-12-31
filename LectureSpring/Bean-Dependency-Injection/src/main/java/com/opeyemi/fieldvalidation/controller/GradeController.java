package com.opeyemi.fieldvalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.opeyemi.fieldvalidation.Grade;
import com.opeyemi.fieldvalidation.service.GradeService;

import jakarta.validation.Valid;


@Controller
public class GradeController {
  @Autowired
  GradeService gradeService;

  @GetMapping(value = "/")
  public String gradeForm(Model model, @RequestParam(required = false) String id){
    model.addAttribute("grade", gradeService.getGradeById(id));
    return "form";
  }

  @PostMapping("/handleSubmit")
  public String SubmitForm(@Valid Grade grade, BindingResult result, RedirectAttributes redirectAttributes){
    if (result.hasErrors()) return "form";
    gradeService.submitGrade(grade, redirectAttributes);
    return "redirect:/grade";
  }

  @GetMapping("/grade")
  public String getGrades(Model model){
    model.addAttribute("grade", gradeService.getGrades());
    return "grades";
  }

}
