import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class CourseSectionTest {

    private CourseSection courseSection;

    @Before
    public void setUp() {
        // Create a CourseSection instance with sample data for testing
        Lecturer lecturer = new Lecturer("LecturerName", "LecturerSurname", "lecturer", "password");
        ArrayList<TimeInterval> dates = new ArrayList<>();
        dates.add(new TimeInterval("2023-01-01", "2023-02-01"));
        dates.add(new TimeInterval("2023-02-15", "2023-03-15"));

        courseSection = new CourseSection("CS101", "Introduction to Java", "Introductory course",
                "None", dates, "A", lecturer, 50);
    }

    @Test
    public void testAddDate() {
        // Test adding a date to the course section
        TimeInterval newDate = new TimeInterval("2023-03-30", "2023-04-30");
        assertTrue(courseSection.addDate(newDate));
        assertTrue(courseSection.getDates().contains(newDate));
    }

    @Test
    public void testRemoveDate() {
        // Test removing a date from the course section
        TimeInterval dateToRemove = courseSection.getDates().get(0);
        assertTrue(courseSection.removeDate(dateToRemove));
        assertFalse(courseSection.getDates().contains(dateToRemove));
    }

    @Test
    public void testGetCourseSectionInfo() {
        // Assuming getCourseSectionInfo returns a non-null string, just test that it runs without errors
        assertNotNull(courseSection.getCourseSectionInfo());
    }
}
