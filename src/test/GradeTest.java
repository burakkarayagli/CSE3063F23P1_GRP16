import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class GradeTest {

    private Course expectedCourse;
    private Grade grade;

    @Before
    public void setUp() {
        expectedCourse = new Course("CSE1200", "Introduction to Computer Engineering", "", "");
        grade = new Grade(expectedCourse, "AA");
    }

    @Test
    public void testGetCourse() {
        assertEquals(expectedCourse, grade.getCourse());
    }

    @Test
    public void testGetGrade() {
        assertEquals("AA", grade.getGrade());
    }
}
