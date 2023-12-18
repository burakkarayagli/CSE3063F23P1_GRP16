package contollers;

import models.Course;
import models.Lecturer;

public class LecturerController {
    Lecturer lecturer;

    public LecturerController(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public LecturerController() {

    }

    public void addLecturedCourse(Course course) {
        this.lecturer.addLecturedCourses(course);
    }

}
