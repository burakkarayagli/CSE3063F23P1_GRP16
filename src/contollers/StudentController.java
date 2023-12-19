package contollers;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import models.Course;
import models.Student;
import models.Transcript;

public class StudentController {

    private static final Logger logger = Logger.getLogger(StudentController.class);
    private Student student;

    public StudentController(Student student) {
        this.student = student;
    }

    public StudentController() {

    }

    // Adds the course to the selected courses of the student.
    public void addCourse(Course course) {
        try {
            student.addCourse(course);
            logger.info("Course added: " + course.getShortName() + " to student:" + student.getPersonName());
        } catch (Exception e) {
            logger.error("Error occured while adding course:" + course.getShortName() + " to student:"
                    + student.getPersonName());
        }
    }

    // Drops the course from the selected courses of the student.
    public void dropCourse(Course course) {
        try {
            student.dropCourse(course);
            logger.info("Course dropped: " + course.getShortName() + " from student:" + student.getPersonName());
        } catch (Exception e) {
            logger.error("Error occured while dropping course:" + course.getShortName() + " from student:"
                    + student.getPersonName());
        }
    }

    // Returns the available courses for the student.
    public ArrayList<Course> getAvailableCourses() {
        try {
            return student.getAvailableCourses();
        } catch (Exception e) {
            logger.error("Error occured while getting available courses for student:" + student.getPersonName());
            return null;
        }
    }

    // Returns the selected courses of the student.
    public ArrayList<Course> getSelectedCourses() {
        try {
            return student.getSelectedCourses();
        } catch (Exception e) {
            logger.error("Error occured while getting selected courses for student:" + student.getPersonName());
            return null;
        }
    }

    // Returns person name of the student.
    public String getPersonName() {
        try {
            return student.getPersonName();
        } catch (Exception e) {
            logger.error("Error occured while getting person name for student:" + student.getPersonName());
            return null;
        }
    }

    // Returns person surname of the student.
    public String getPersonSurname() {
        try {
            return student.getPersonSurname();
        } catch (Exception e) {
            logger.error("Error occured while getting person surname for student:" + student.getPersonName());
            return null;
        }
    }

    // Returns the student's transcript.
    public Transcript getTranscript() {
        try {
            return student.getTranscript();
        } catch (Exception e) {
            logger.error("Error occured while getting transcript for student:" + student.getPersonName());
            return null;
        }
    }
}