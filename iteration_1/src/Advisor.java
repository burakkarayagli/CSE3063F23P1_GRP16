
import java.util.ArrayList;
import java.util.List;

public class Advisor extends Staff {

    private List<Student> students;

    public Advisor(String personName, String personSurname, String username, String password,
            String reputation, ArrayList<TimeInterval> officeHours, int salary, String employmentStatus,
            List<Student> students) {
        super(personName, personSurname, username, password, reputation, officeHours, salary,
                employmentStatus);
        this.students = students;
    }

    public Advisor() {
        
    }

    public void printTranscriptInfo() {
        System.out.println("STUDENT TRANSCRIPT");
        System.out.println("-------------------------------------------------");
        System.out.println();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public boolean deleteStudent(Student student) {
        return students.remove(student);
    }

}
