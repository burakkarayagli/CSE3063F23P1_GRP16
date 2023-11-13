package src;
import java.util.List;

public class Advisor extends Staff{
    public Advisor(int personID, String personName, String personSurname, String username, String password, String reputation, int officeHours, int salary, String employmentStatus, List<Student> advisee) {
        super(personID, personName, personSurname, username, password, reputation, officeHours, salary, employmentStatus);
        this.advisee = advisee;
    }

    private List<Student> advisee;


    public List<Student> getAdvisee() {
        return advisee;
    }

    public void setAdvisee(List<Student> advisee) {
        this.advisee = advisee;
    }
}
