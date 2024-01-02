import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class AdvisorTest {

    private Advisor advisor;

    @Before
    public void setUp() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Name1", "Surname1", "username1", "password1"));
        students.add(new Student("Name2", "Surname2", "username2", "password2"));

        advisor = new Advisor("AdvisorName", "AdvisorSurname", "advisor", "password",
                "Excellent", new ArrayList<>(), 50000, "Full-Time", students);
    }

    @Test
    public void testAddStudent() {
        Student newStudent = new Student("NewName", "NewSurname", "newUsername", "newPassword");
        assertTrue(advisor.addStudent(newStudent));
        assertTrue(advisor.getStudents().contains(newStudent));
    }

    @Test
    public void testDeleteStudent() {
        Student studentToDelete = advisor.getStudents().get(0);
        assertTrue(advisor.deleteStudent(studentToDelete));
        assertFalse(advisor.getStudents().contains(studentToDelete));
    }


    @Test
    public void testPrintTranscriptInfo() {
        advisor.printTranscriptInfo();
    }
}
