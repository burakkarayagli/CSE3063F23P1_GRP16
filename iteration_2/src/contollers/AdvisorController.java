package contollers;

import java.util.ArrayList;
import java.util.List;

import models.*;

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

    public boolean approveStudentSelection(Student student, ArrayList<Integer> selections) {
        return advisor.approveStudent(student, selections);
    }
    public boolean rejectStudentSelection(Student student, String selections) throws Exception{
        return advisor.rejectStudent(student, selections);
    }

}
