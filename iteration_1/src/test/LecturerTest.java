import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class LecturerTest {

    private Lecturer lecturer;

    @Before
    public void setUp() {
        // Create a Lecturer instance with sample data for testing
        ArrayList<TimeInterval> officeHours = new ArrayList<>();
        officeHours.add(new TimeInterval("Monday", "10:00 AM", "12:00 PM"));
        officeHours.add(new TimeInterval("Wednesday", "02:00 PM", "04:00 PM"));

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CS101", "Introduction to Programming"));

        lecturer = new Lecturer("LecturerName", "LecturerSurname", "lecturer", "password",
                "Excellent", officeHours, 60000, "Full-Time", courses);
    }

    @Test
    public void testAddCourse() {
        // Test adding a course to the lecturer's list
        Course newCourse = new Course("CS202", "Data Structures");
        assertTrue(lecturer.addCourse(newCourse));
        assertTrue(lecturer.getCourses().contains(newCourse));
    }

    @Test
    public void testRemoveCourse() {
        // Test removing a course from the lecturer's list
        Course courseToRemove = lecturer.getCourses().get(0);
        assertTrue(lecturer.removeCourse(courseToRemove));
        assertFalse(lecturer.getCourses().contains(courseToRemove));
    }

    // Add more test methods to cover other functionalities of the Lecturer class

    @Test
    public void testGetCourses() {
        // Assuming getCourses returns a non-null list, just test that it runs without errors
        assertNotNull(lecturer.getCourses());
    }
}
