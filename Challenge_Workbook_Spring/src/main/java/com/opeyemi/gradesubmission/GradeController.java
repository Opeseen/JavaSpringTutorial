package com.opeyemi.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GradeController {
  
  @GetMapping("/grade")
  public String getGrades(Model model){
    Grade grade = new Grade("Harry","Maths","C-");
    Grade grade1 = new Grade("Mike","English","B+");
    Grade grade2 = new Grade("Tom","Econs","A+");
    Grade grade3 = new Grade("Kenny","Poem","D+");
    Grade grade4 = new Grade("John","Physics","B+");
    model.addAttribute("grade",grade);
    model.addAttribute("grade1",grade1);
    model.addAttribute("grade2",grade2);
    model.addAttribute("grade3",grade3);
    model.addAttribute("grade4",grade4);
    return "grades";
  }
}
