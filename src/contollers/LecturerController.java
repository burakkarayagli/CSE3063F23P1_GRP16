package contollers;

import java.util.ArrayList;

import models.Course;
import models.Lecturer;
import models.Student;

public class LecturerController {
    private Lecturer lecturer;

    public LecturerController(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public LecturerController() {

    }

    public boolean addLecturedCourse(Course course) {
        return this.lecturer.addLecturedCourses(course);
    }

    public boolean deleteLecturedCourses(Course course){
        return this.lecturer.deleteLecturedCourses(course);
    }

    public ArrayList<Student> viewEnrolledStudents(Course course){
        return this.lecturer.viewEnrolledStudents(course);
    }



}
