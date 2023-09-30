package com.ltp.gradesubmission.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.ltp.gradesubmission.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long>{
    Optional<Grade> findByStudentIdAndCourseId(Long StudentId, Long CourseId);
    @Transactional
    void deleteByStudentIdAndCourseId(Long StudentId, Long CourseId);
    List<Grade> findByStudentId(Long StudentId);
    List<Grade> findByCourseId(Long CourseId);
}