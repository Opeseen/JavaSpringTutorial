package com.ltp.gradesubmission;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.StudentRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor

@SpringBootApplication
public class GradeSubmissionApplication implements CommandLineRunner{

	StudentRepository studentRepository;
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Student[] students = new Student[] {
			new Student("Harry", LocalDate.parse(("1980-07-31"))),
			new Student("Mike", LocalDate.parse(("1980-03-01"))),
			new Student("Ope", LocalDate.parse(("1979-09-19"))),
			new Student("Yomex", LocalDate.parse(("1980-07-30")))
   		};
		for (int i = 0; i < students.length; i++){
			studentRepository.save(students[i]);
		}

		Course[] courses = new Course[] {
            new Course("charms", "chm02", "In this class, you will learn spells concerned with giving an object new and unexpected properties."),
            new Course("Arts", "art007", "In this class, you will learn defensive techniques against the dark arts."),
            new Course("Magical", "mag234", "In this class, you will learn the study of magical plants and how to take care of, utilise and combat them."),
            new Course("History", "HIS393", "In this class, you will learn about significant events in wizarding history."),
            new Course("Food", "fd002", "In this class, you will learn correct mixing and stirring of ingredients to create mixtures with magical effects."),
            new Course("Styles", "sty01", "In this class, you will learn the art of changing the form or appearance of an object.")
        };
		for (int i = 0; i < courses.length; i++){
			courseRepository.save(courses[i]);
		}
	
	}

}
