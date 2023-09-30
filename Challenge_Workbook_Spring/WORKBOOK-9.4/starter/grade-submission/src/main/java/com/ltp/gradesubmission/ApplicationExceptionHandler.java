package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ltp.gradesubmission.entity.ErrorResponse;
import com.ltp.gradesubmission.exception.CourseNotFoundException;
import com.ltp.gradesubmission.exception.GradeAndCoursesNotFoundException;
import com.ltp.gradesubmission.exception.NoRecordFoundException;
import com.ltp.gradesubmission.exception.StudentGradeNotFoundException;
import com.ltp.gradesubmission.exception.StudentNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
  @ExceptionHandler({CourseNotFoundException.class, GradeAndCoursesNotFoundException.class, StudentGradeNotFoundException.class, StudentNotFoundException.class, NoRecordFoundException.class})
  public ResponseEntity<Object> handleResourcesNotFoundExceptions(RuntimeException ex){
    ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(ex.getLocalizedMessage()));
    return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
  }
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    List<String> errors = new ArrayList<>();
    for(ObjectError error : ex.getBindingResult().getAllErrors()){
      errors.add(error.getDefaultMessage());
    }
    return new ResponseEntity<Object>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
  }

}
