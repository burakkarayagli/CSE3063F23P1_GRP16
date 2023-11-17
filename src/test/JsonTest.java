
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;

public class JsonTest {
    public Json json = new Json();

    @Test
    void testStudentNumber() {
        assertEquals(6, json.getStudents().size());
    }

}
