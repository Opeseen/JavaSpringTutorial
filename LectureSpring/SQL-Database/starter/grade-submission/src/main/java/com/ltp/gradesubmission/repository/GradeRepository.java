package com.ltp.gradesubmission.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ltp.gradesubmission.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long>{
    List<Grade> findByStudentId(Long StudentId);
}