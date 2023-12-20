package tests;

import models.Course;
import models.Student;
import models.Transcript;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {
    private Student student;
    private Course course;

    @Before
    public void setup() {
        student = new Student();
        course = new Course();
    }

    @Test
    public void testAddress() {
        student.setAddress("123 Street");
        assertEquals("123 Street", student.getAddress());
    }

    @Test
    public void testPhoneNumber() {
        student.setPhoneNumber("1234567890");
        assertEquals("1234567890", student.getPhoneNumber());
    }

    @Test
    public void testSemester() {
        student.setSemester(1);
        assertEquals(1, student.getSemester());
    }

    @Test
    public void testEntranceYear() {
        student.setEntranceYear(2022);
        assertEquals(2022, student.getEntranceYear());
    }

    @Test
    public void testStatus() {
        student.setStatus("approved");
        assertEquals("approved", student.getStatus());
    }

    @Test
    public void testSelectedCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(course);
        student.setSelectedCourses(courses);
        assertEquals(courses, student.getSelectedCourses());
    }

    @Test
    public void testTranscript() {
        Transcript transcript = new Transcript();
        student.setTranscript(transcript);
        assertEquals(transcript, student.getTranscript());
    }

    @Test
    public void testAddCourse() {
        student.setStatus("approved");
        assertTrue(student.addCourse(course));
    }

    @Test
    public void testDropCourse() {
        student.setStatus("approved");
        student.addCourse(course);
        assertTrue(student.dropCourse(course));
    }
}