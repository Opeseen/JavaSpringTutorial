package com.ltp.gradesubmission.exception;

public class GradeAndCoursesNotFoundException extends RuntimeException { 

    public GradeAndCoursesNotFoundException(Long studentId, Long courseId) {
        super("The grade with student id: '" + studentId + "' and course id: '" + courseId + "' does not exist in our records");
    }

}