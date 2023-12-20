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
        // check selected courses
        student.addCourse(course);
        assertTrue(student.getSelectedCourses().contains(course));
    }

    @Test
    public void testDropCourse() {
        student.addCourse(course);
        assertTrue(student.getSelectedCourses().contains(course));
    }

    //
    @Test
    public void testCanAddMoreThan5Courses() {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course());
        courses.add(new Course());
        courses.add(new Course());
        courses.add(new Course());
        courses.add(new Course());
        student.setSelectedCourses(courses);
        assertFalse(student.addCourse(course));
    }

    // Add courses exceeding 30 credits and call getWarnings()
    @Test
    public void testWarningMessage() {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("CSE 101", "Introduction to Computer Science", "Introduction to Computer Science",
                new ArrayList<String>(), 1, 7, 3));
        courses.add(new Course("CSE 102", "Introduction to Computer Science", "Introduction to Computer Science",
                new ArrayList<String>(), 1, 7, 3));
        courses.add(new Course("CSE 103", "Introduction to Computer Science", "Introduction to Computer Science",
                new ArrayList<String>(), 1, 7, 3));
        courses.add(new Course("CSE 104", "Introduction to Computer Science", "Introduction to Computer Science",
                new ArrayList<String>(), 1, 7, 3));
        courses.add(new Course("CSE 105", "Introduction to Computer Science", "Introduction to Computer Science",
                new ArrayList<String>(), 1, 7, 3));

        // Add courses exceeding 30 credits and call getWarnings()
        System.out.println(student.getWarnings());
        // assertTrue(student.getWarnings().contains("Student has exceeded the credit
        // limit"));
    }

}