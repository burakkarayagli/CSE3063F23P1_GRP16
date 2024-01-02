import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
// Baris Giray Akman unit test
public class StaffTest {

    Staff staff;

    @Before
    public void setUp(){
        staff = new Staff();
        staff.setPersonName("Ahmet");
        staff.setPersonSurname("Yilmaz");
        staff.setUsername("yilmazahmet");
        staff.setPassword("789456123");
        staff.setReputation("Dr.");
        staff.setOfficeHours(new ArrayList<TimeInterval>());
        staff.setSalary(29350);
        staff.setEmploymentStatus("true");
    }

    @Test
    public void testGetReputation(){
        assertEquals("Dr.", staff.getReputation());
    }

    @Test
    public void testGetOfficeHours(){
        assertEquals(new ArrayList<TimeInterval>(), staff.getOfficeHours());
    }

    @Test
    public void testGetSalary(){
        assertEquals(29350, staff.getSalary());
    }

    @Test
    public void testGetEmploymentStatus(){
        assertEquals("true", staff.getEmploymentStatus());
    }

}
