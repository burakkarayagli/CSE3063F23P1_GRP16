package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import models.Course;

public class CourseTest {

    @Test
    public void testAddPrerequisite() {
        Course course = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        assertTrue(course.addPrerequisite("CS100"));
        assertTrue(course.getPrerequisite().contains("CS100"));
    }

    @Test
    public void testRemovePrerequisite() {
        Course course = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        course.addPrerequisite("CS100");
        assertTrue(course.removePrerequisite("CS100"));
        assertFalse(course.getPrerequisite().contains("CS100"));
    }

    @Test
    public void testSetCreditValid() {
        Course course = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        course.setCredit(5);
        assertEquals(5, course.getCredit());
    }

    @Test
    public void testSetCreditInvalidLow() {
        Course course = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        // Attempt to set a credit less than 1
        course.setCredit(0);
        // Check that the credit remains unchanged (should be 3)
        assertEquals(3, course.getCredit());
    }

    @Test
    public void testSetCreditInvalidHigh() {
        Course course = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        // Attempt to set a credit greater than 9
        course.setCredit(10);
        // Check that the credit remains unchanged (should be 3)
        assertEquals(3, course.getCredit());
    }

    @Test
    public void testSetClassHoursValid() {
        Course course = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        course.setClassHours(5);
        assertEquals(5, course.getClassHours());
    }

    @Test
    public void testSetClassHoursInvalidLow() {
        Course course = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        // Attempt to set class hours less than 1
        course.setClassHours(0);
        // Check that the class hours remain unchanged (should be 3)
        assertEquals(3, course.getClassHours());
    }

    @Test
    public void testSetClassHoursInvalidHigh() {
        Course course = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        // Attempt to set class hours greater than 9
        course.setClassHours(10);
        // Check that the class hours remain unchanged (should be 3)
        assertEquals(3, course.getClassHours());
    }

    // Add more tests for other methods as needed

}
