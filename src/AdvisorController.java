import java.util.List;

public class AdvisorController {

    private Advisor advisor;

    public AdvisorController(Advisor advisor) {
        this.advisor = advisor;
    }

    public List<Student> getStudents() {
        return advisor.getStudents();
    }

    public void addStudent(Student student) {
        advisor.addStudent(student);
    }

    public void deleteStudent(Student student) {
        advisor.deleteStudent(student);
    }

    public void studentCourseOrganization(Student student) {
        advisor.studentCourseOrganization();
    }

    public List<Course> getCombinedCourses(Student student) {
        return advisor.getCombinedCourses(student);
    }

    public boolean approveStudentSelection(Student student, String selections) {
        return advisor.approveStudent(student, selections);
    }

}
