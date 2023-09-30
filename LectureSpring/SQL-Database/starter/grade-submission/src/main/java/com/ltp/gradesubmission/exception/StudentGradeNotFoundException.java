package com.ltp.gradesubmission.exception;

public class StudentGradeNotFoundException extends RuntimeException { 

    public StudentGradeNotFoundException(Long studentId) {
        super("No grade exist with student id: '" + studentId + "' in our records");
    }

}