
import java.util.List;

public class Advisor extends Staff {

    private List<Student> students;
    public Advisor(String personName, String personSurname, String username, String password,
            String reputation, int officeHours, int salary, String employmentStatus, List<Student> students) {
        super(personName, personSurname, username, password, reputation, officeHours, salary,
                employmentStatus);
        this.students = students;
    }


    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
