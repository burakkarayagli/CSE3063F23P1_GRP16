package contollers;

import java.util.ArrayList;

import models.Course;
import models.Student;
import models.Transcript;

public class StudentController {

    private Student student;

    public StudentController(Student student) {
        this.student = student;
    }

    public StudentController() {

    }

    // Adds the course to the selected courses of the student.
    public void addCourse(Course course) {
        student.addCourse(course);
    }

    // Drops the course from the selected courses of the student.
    public void dropCourse(Course course) {
        student.dropCourse(course);
    }

    // Returns the available courses for the student.
    public ArrayList<Course> getAvailableCourses() {
        return student.getAvailableCourses();
    }

    // Returns the selected courses of the student.
    public ArrayList<Course> getSelectedCourses() {
        return student.getSelectedCourses();
    }

    // Returns person name of the student.
    public String getPersonName() {
        return student.getPersonName();
    }

    // Returns person surname of the student.
    public String getPersonSurname() {
        return student.getPersonSurname();
    }

    // Returns the student's transcript.
    public Transcript getTranscript() {
        return student.getTranscript();
    }
}