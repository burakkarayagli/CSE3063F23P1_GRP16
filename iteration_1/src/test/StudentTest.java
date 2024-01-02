import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {

    Student student;

    @Before
    public void setUp() throws Exception {
        student = new Student();
        student.setPersonName("John");
        student.setPersonSurname("Doe");
        student.setUsername("johndoe");
        student.setPassword("123456");
        student.setAddress("Istanbul");
        student.setPhoneNumber("1234567890");
        student.setStudentYear(1);
        student.setEntranceYear(2020);
        student.setApproved(true);
        student.setCourses(new ArrayList<CourseSection>());
        student.setTranscript(new Transcript());

    }

    @Test
    public void testGetAddress() {
        assertEquals("Istanbul", student.getAddress());
    }

    @Test
    public void testGetPhoneNumber() {
        assertEquals("1234567890", student.getPhoneNumber());
    }

    @Test
    public void testGetStudentYear() {
        assertEquals(1, student.getStudentYear());
    }

    @Test
    public void testGetEntranceYear() {
        assertEquals(2020, student.getEntranceYear());
    }

    @Test
    public void testGetApproved() {
        assertEquals(true, student.getApproved());
    }

    @Test
    public void testGetCourses() {
        assertEquals(0, student.getCourses().size());
    }
}
