package com.opeyemi.fieldvalidation.service;

import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.opeyemi.fieldvalidation.Constant;
import com.opeyemi.fieldvalidation.Grade;
import com.opeyemi.fieldvalidation.repository.GradeRepository;

public class GradeService {
    GradeRepository gradeRepository = new GradeRepository();
    
    public Grade getGrade(int index){
        return gradeRepository.getGrade(index);
    }

    public void addGrade(Grade grade){
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(Grade grade, int index){
        gradeRepository.updateGrade(grade,index);
    }

    public List<Grade> getGrades(){
        return gradeRepository.getGrades();
    }

    public int getGradeIndex(String id){
        for(int i = 0; i < getGrades().size(); i++){
            if(getGrade(i).getId().equals(id)) return i;
        }
        return Constant.NOT_FOUND;
    }

    public Grade getGradeById(String id){
        int index = getGradeIndex(id);
        return index == Constant.NOT_FOUND ? new Grade() : getGrade(index);
    }

    public void submitGrade(Grade grade, RedirectAttributes  redirectAttributes){
        
        int index = getGradeIndex(grade.getId());
        if (index == Constant.NOT_FOUND){
            redirectAttributes.addFlashAttribute("status", Constant.SUCCESS_STATUS);
            addGrade(grade);
        }else{
            redirectAttributes.addFlashAttribute("status", Constant.UPDATE_STATUS);
            updateGrade(grade, index);
        }
    }
}
