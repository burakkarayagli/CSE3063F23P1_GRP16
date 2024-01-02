package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import models.Advisor;
import models.Course;
import models.Student;

public class AdvisorTest {
    Advisor advisor;
    Student student;
    @Before
    public void setup(){
        advisor = new Advisor();
        student = new Student();
    }
    @Test
    public void testStudents(){
        List<Student> students = new ArrayList<>();
        students.add(student);
        advisor.setStudents(students);
        assertEquals(students, advisor.getStudents());
    }

    @Test
    public void testAddStudent(){
        advisor.setStudents(new ArrayList<>());
        advisor.addStudent(student);
        assertTrue(advisor.getStudents().contains(student));
    }

    @Test
    public void testDeleteStudent(){
        advisor.setStudents(new ArrayList<>());
        advisor.addStudent(student);
        assertTrue(advisor.getStudents().contains(student));
    }

    @Test
    public void testRejectStudent() throws Exception{
        advisor.setStudents(new ArrayList<>());
        advisor.addStudent(student);
        String selections = "1,2";
        student.addCourse(new Course());
        student.addCourse(new Course());
        assertTrue(advisor.rejectStudent(student, selections));
    }


    @Test
    public void testApproveStudent(){
        advisor.setStudents(new ArrayList<>());
        advisor.addStudent(student);
        ArrayList<Integer> selections = new ArrayList<>();
        // Assuming that inputs are as demanded.
        selections.add(1);
        selections.add(2);
        student.addCourse(new Course());
        student.addCourse(new Course());
        assertTrue(advisor.approveStudent(student, selections));
    }



    

}
