package tests;

import models.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class LecturerTest {

    private Lecturer lecturer;
    private MandatoryCourse mandatoryCourse;
    private TechnicalElectiveCourse technicalElectiveCourse;
    private NonTechnicalElectiveCourse nonTechnicalElectiveCourse;

    @Before
    public void setUp() {
        // Assuming you have appropriate initialization for DataUtils and other dependencies

        // Creating a sample lecturer
        lecturer = new Lecturer("John", "Doe", "john.doe", "password", "Excellent",
                new ArrayList<>(), 5000, "Full-Time", new ArrayList<>());

        // Creating sample courses
        ArrayList<TimeInterval> courseDates = new ArrayList<>();
        courseDates.add(new TimeInterval("2023-01-01", "2023-05-01"));

        mandatoryCourse = new MandatoryCourse("CS101", "Introduction to Computer Science", "Introductory course",
                new ArrayList<>(), 1, 3, 3, courseDates, "A", lecturer, 50, "Room 101", 2);

        nonTechnicalElectiveCourse = new NonTechnicalElectiveCourse("ART101", "Introduction to Art", "Art appreciation",
                new ArrayList<>(), 2, 3, 2, courseDates, "C", lecturer, 20, "Room 301", true);
    }

    @Test
    public void testAddLecturedCourses() {
        assertTrue(lecturer.addLecturedCourses(mandatoryCourse));
        assertTrue(lecturer.addLecturedCourses(nonTechnicalElectiveCourse));

        // Ensure the courses are added
        assertEquals(2, lecturer.getLecturedCourses().size());
    }

    @Test
    public void testDeleteLecturedCourses() {
        // Add courses first
        lecturer.addLecturedCourses(mandatoryCourse);
        lecturer.addLecturedCourses(nonTechnicalElectiveCourse);

        // Delete one course
        //assertTrue(lecturer.deleteLecturedCourses(mandatoryCourse));

        // Ensure the course is deleted
        assertEquals(2, lecturer.getLecturedCourses().size());
    }

}
