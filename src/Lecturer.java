import java.util.List;

public class Lecturer extends Staff {
    public Lecturer(int personID, String personName, String personSurname, String username, String password,
            String reputation, int officeHours, int salary, String employmentStatus, List<Course> courses) {
        super(personID, personName, personSurname, username, password, reputation, officeHours, salary,
                employmentStatus);
        this.courses = courses;
    }

    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
