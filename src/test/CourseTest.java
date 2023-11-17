import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class CourseTest {
    Course course;

    @Before
    void setup() {
        course = new Course();
        course.setShortName("AAA");
        course.setFullName("BBB");
        course.setPrerequisite("CCC");
        course.setDescription("DDDD");
    }

    @Test
    void testShortName() {
        assertEquals(course.getShortName(), "AAA");
    }

    @Test
    void testFullName() {
        assertEquals(course.getFullName(), "BBB");
    }

    @Test
    void setPrerequisite() {
        assertEquals(course.getPrerequisite(), "CCC");
    }

    @Test
    void testDescription() {
        assertEquals(course.getDescription(), "DDDD");
    }

}
