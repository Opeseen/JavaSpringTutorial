package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.CourseNotFoundException;
import com.ltp.gradesubmission.exception.GradeAndCoursesNotFoundException;
import com.ltp.gradesubmission.exception.StudentGradeNotFoundException;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    GradeRepository gradeRepository;
    StudentRepository studentRepository;
    CourseRepository courseRepository;
    
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        Optional<Grade> grade =  gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (grade.isPresent()) {
            return grade.get();
        } else {
            throw new GradeAndCoursesNotFoundException(studentId, courseId);
        }
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();
        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (grade.isPresent()) {
            Grade unrappedGrade = grade.get();
            unrappedGrade.setScore(score);
            return gradeRepository.save(unrappedGrade);
        } else {
            throw new GradeAndCoursesNotFoundException(studentId, courseId);
        }
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (grade.isPresent()) {
            gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
        } else {
            throw new GradeAndCoursesNotFoundException(studentId, courseId);
        }
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        List<Grade> grade = gradeRepository.findByStudentId(studentId);
        if (grade.isEmpty()) {
            throw new StudentGradeNotFoundException(studentId);
        } else {
            return gradeRepository.findByStudentId(studentId);
        }
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        List<Grade> courseGrade = gradeRepository.findByCourseId(courseId);
        if (courseGrade.isEmpty()) {
            throw new CourseNotFoundException(courseId);
        } else {
            return gradeRepository.findByCourseId(courseId);
        }
        
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }

}
