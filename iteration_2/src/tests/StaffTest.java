package tests;

import java.util.ArrayList;
import models.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class StaffTest {

    @Test
    public void testGetReputation() {
        Staff staff = new Staff("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time");
        assertEquals("Excellent", staff.getReputation());
    }

    @Test
    public void testSetReputation() {
        Staff staff = new Staff("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time");
        staff.setReputation("Good");
        assertEquals("Good", staff.getReputation());
    }

    @Test
    public void testGetOfficeHours() {
        ArrayList<TimeInterval> officeHours = new ArrayList<>();
        officeHours.add(new TimeInterval("09:00", "12:00", "Monday"));
        officeHours.add(new TimeInterval("14:00", "17:00", "Wednesday"));

        Staff staff = new Staff("John", "Doe", "johndoe", "password", "Excellent", officeHours, 50000, "Full-time");

        assertEquals(officeHours, staff.getOfficeHours());
    }

    @Test
    public void testSetOfficeHours() {
        ArrayList<TimeInterval> officeHours = new ArrayList<>();
        officeHours.add(new TimeInterval("09:00", "12:00", "Monday"));
        officeHours.add(new TimeInterval("14:00", "17:00", "Wednesday"));

        Staff staff = new Staff("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time");

        staff.setOfficeHours(officeHours);
        assertEquals(officeHours, staff.getOfficeHours());
    }

    @Test
    public void testAddOfficeHours() {
        Staff staff = new Staff("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time");

        TimeInterval officeHour = new TimeInterval("09:00", "12:00", "Monday");
        assertTrue(staff.addOfficeHours(officeHour));
        assertTrue(staff.getOfficeHours().contains(officeHour));
    }

    @Test
    public void testDeleteOfficeHours() {
        ArrayList<TimeInterval> officeHours = new ArrayList<>();
        officeHours.add(new TimeInterval("09:00", "12:00", "Monday"));
        officeHours.add(new TimeInterval("14:00", "17:00", "Wednesday"));

        Staff staff = new Staff("John", "Doe", "johndoe", "password", "Excellent", officeHours, 50000, "Full-time");

        TimeInterval officeHourToDelete = new TimeInterval("09:00", "12:00", "Monday");
        assertFalse(staff.getOfficeHours().contains(officeHourToDelete));
    }

    @Test
    public void testGetSalary() {
        Staff staff = new Staff("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time");
        assertEquals(50000, staff.getSalary());
    }

    @Test
    public void testSetSalary() {
        Staff staff = new Staff("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time");
        staff.setSalary(60000);
        assertEquals(60000, staff.getSalary());
    }

    @Test
    public void testGetEmploymentStatus() {
        Staff staff = new Staff("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time");
        assertEquals("Full-time", staff.getEmploymentStatus());
    }

    @Test
    public void testSetEmploymentStatus() {
        Staff staff = new Staff("John", "Doe", "johndoe", "password", "Excellent", new ArrayList<>(), 50000, "Full-time");
        staff.setEmploymentStatus("Part-time");
        assertEquals("Part-time", staff.getEmploymentStatus());
    }

    // Add more tests for other methods as needed

}

