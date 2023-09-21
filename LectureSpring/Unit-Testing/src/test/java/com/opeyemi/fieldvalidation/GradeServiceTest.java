package com.opeyemi.fieldvalidation;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.opeyemi.fieldvalidation.pojo.Grade;
import com.opeyemi.fieldvalidation.repository.GradeRepository;
import com.opeyemi.fieldvalidation.service.GradeService;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {
    
    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeService gradeService;

    @Test
    public void getGradesFromRepoTest(){
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
            new Grade("Harry","Potions","C"),
            new Grade("Mike","Maths","A")
        ));

        List<Grade> result = gradeService.getGrades();

        assertEquals("Harry", result.get(0).getName());
        assertEquals("Maths", result.get(1).getSubject());
        assertEquals("A", result.get(1).getScore());
    }

    @Test
    public void getIndexTest(){
        Grade grade = new Grade("Harry","Potions","C");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        int valid = gradeService.getGradeIndex(grade.getId());
        int notvalid = gradeService.getGradeIndex("123");

        assertEquals(0, valid);
        assertEquals(Constant.NOT_FOUND, notvalid);
    }

    @Test
    public void returnGradeByIdTest(){
        Grade grade = new Grade("Harry","Potions","C");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        String id = grade.getId();
        Grade result = gradeService.getGradeById(id);

        assertEquals(grade, result);
    }

    @Test
    public void addGradeTest(){
        Grade grade = new Grade("Harry","Potions","C");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        Grade newGrade = new Grade("Mike","CRS","A");
        gradeService.submitGrade(newGrade);
        verify(gradeRepository, times(1)).addGrade(newGrade);  

    }

    @Test
    public void updateGradeTest(){
        Grade grade = new Grade("Harry","Potions","C");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        grade.setScore("A");
        gradeService.submitGrade(grade);
        verify(gradeRepository, times(1)).updateGrade(grade, 0);

    }


}
