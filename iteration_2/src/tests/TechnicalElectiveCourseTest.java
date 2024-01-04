package tests;

import models.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class TechnicalElectiveCourseTest {

    @Test
    public void testIsTechnical() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", new ArrayList<>());

        TechnicalElectiveCourse electiveCourse = new TechnicalElectiveCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101");

        assertTrue(electiveCourse.isTechnical());
    }

    @Test
    public void testIsMandatory() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", new ArrayList<>());

        TechnicalElectiveCourse electiveCourse = new TechnicalElectiveCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101");

        assertFalse(electiveCourse.isMandatory());
    }

    @Test
    public void testSetDatesAndGetDates() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", new ArrayList<>());

        TechnicalElectiveCourse electiveCourse = new TechnicalElectiveCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101");

        ArrayList<TimeInterval> dates = new ArrayList<>();
        dates.add(new TimeInterval("2023-01-01", "09:00", "12:00"));
        dates.add(new TimeInterval("2023-01-02", "14:00", "17:00"));

        electiveCourse.setDates(dates);
        assertEquals(dates, electiveCourse.getDates());
    }

    @Test
    public void testAddDate() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", new ArrayList<>());

        TechnicalElectiveCourse electiveCourse = new TechnicalElectiveCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101");

        TimeInterval date = new TimeInterval("2023-01-01", "09:00", "12:00");
        assertTrue(electiveCourse.addDate(date));
        assertTrue(electiveCourse.getDates().contains(date));
    }

    @Test
    public void testRemoveDate() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", new ArrayList<>());

        TechnicalElectiveCourse electiveCourse = new TechnicalElectiveCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101");

        TimeInterval date = new TimeInterval("2023-01-01", "09:00", "12:00");
        electiveCourse.addDate(date);

        assertTrue(electiveCourse.removeDate(date));
        assertFalse(electiveCourse.getDates().contains(date));
    }

    @Test
    public void testSetSectionNameAndGetSectionName() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", new ArrayList<>());

        TechnicalElectiveCourse electiveCourse = new TechnicalElectiveCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101");

        electiveCourse.setSectionName("B");
        assertEquals("B", electiveCourse.getSectionName());
    }

    @Test
    public void testSetLecturerAndGetLecturer() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        Lecturer lecturer1 = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", new ArrayList<>());
        Lecturer lecturer2 = new Lecturer("Jane", "Doe", "janedoe", "password", "Excellent", new ArrayList<>(), 60000, "Full-time", new ArrayList<>());

        TechnicalElectiveCourse electiveCourse = new TechnicalElectiveCourse(baseCourse, new ArrayList<>(), "A", lecturer1, 30, "Room 101");

        electiveCourse.setLecturer(lecturer2);
        assertEquals(lecturer2, electiveCourse.getLecturer());
    }

    @Test
    public void testSetQuotaAndGetQuota() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", new ArrayList<>());

        TechnicalElectiveCourse electiveCourse = new TechnicalElectiveCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101");

        electiveCourse.setQuota(40);
        assertEquals(40, electiveCourse.getQuota());
    }

    @Test
    public void testSetRequiredCreditAndGetRequiredCredit() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", new ArrayList<>());

        TechnicalElectiveCourse electiveCourse = new TechnicalElectiveCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101");

        electiveCourse.setRequiredCredit(6);
        assertEquals(6, electiveCourse.getRequiredCredit());
    }

    @Test
    public void testCheckRequiredCredit() {
        Course baseCourse = new Course("CS101", "Introduction to Computer Science", "An introductory course", new ArrayList<>(), 1, 3, 3);

        Lecturer lecturer = new Lecturer("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time", new ArrayList<>());

        TechnicalElectiveCourse electiveCourse = new TechnicalElectiveCourse(baseCourse, new ArrayList<>(), "A", lecturer, 30, "Room 101");

        electiveCourse.setRequiredCredit(6);

        assertTrue(electiveCourse.checkRequiredCredit(8));
        assertFalse(electiveCourse.checkRequiredCredit(5));
    }

}

