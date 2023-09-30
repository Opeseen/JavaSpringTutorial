package com.ltp.gradesubmission.exception;

public class CourseNotFoundException extends RuntimeException { 

    public CourseNotFoundException(Long courseId) {
        super("No course exist with course id: '" + courseId + "' in our records");
    }

}