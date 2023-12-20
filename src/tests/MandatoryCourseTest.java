package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class MandatoryCourseTest {

    @Test
    public void testAddDate() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        List<Course> lecturerCourses = new ArrayList<>(); // Add courses if needed

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", lecturerCourses);

        MandatoryCourse mandatoryCourse = new MandatoryCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101", 2);

        TimeInterval date = new TimeInterval("2023-01-01", "09:00", "12:00");
        assertTrue(mandatoryCourse.addDate(date));
        assertTrue(mandatoryCourse.getDates().contains(date));
    }

    @Test
    public void testRemoveDate() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        List<Course> lecturerCourses = new ArrayList<>(); // Add courses if needed

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", lecturerCourses);

        MandatoryCourse mandatoryCourse = new MandatoryCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101", 2);

        TimeInterval date = new TimeInterval("2023-01-01", "09:00", "12:00");
        mandatoryCourse.addDate(date);

        assertTrue(mandatoryCourse.removeDate(date));
        assertFalse(mandatoryCourse.getDates().contains(date));
    }

    @Test
    public void testHasLabsWithLabs() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        List<Course> lecturerCourses = new ArrayList<>(); // Add courses if needed

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", lecturerCourses);

        MandatoryCourse mandatoryCourse = new MandatoryCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101", 2);

        assertTrue(mandatoryCourse.hasLabs());
    }

    @Test
    public void testHasLabsWithoutLabs() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        List<Course> lecturerCourses = new ArrayList<>(); // Add courses if needed

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", lecturerCourses);

        MandatoryCourse mandatoryCourse = new MandatoryCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101", 0);

        assertFalse(mandatoryCourse.hasLabs());
    }

    @Test
    public void testSetQuotaValid() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        List<Course> lecturerCourses = new ArrayList<>(); // Add courses if needed

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", lecturerCourses);

        MandatoryCourse mandatoryCourse = new MandatoryCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101", 2);

        mandatoryCourse.setQuota(40);
        assertEquals(40, mandatoryCourse.getQuota());
    }

}
