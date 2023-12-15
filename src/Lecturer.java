
import java.util.ArrayList;
import java.util.List;

public class Lecturer extends Staff {
    // private List<Course> courses;

    public Lecturer(String personName, String personSurname, String username, String password,
            String reputation, ArrayList<TimeInterval> officeHours, int salary, String employmentStatus) {
        // List<Course> courses) {
        super(personName, personSurname, username, password, reputation, officeHours, salary,
                employmentStatus);
        // this.courses = courses;
    }

    public List<Course> getLecturedCourses() {
        Json json = new Json();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<MandatoryCourse> mandatoryCourses = json.readMandatoryCourses();
        ArrayList<NonTechnicalElectiveCourse> nonTechnicalElectives = json.readNonTechnicalElectiveCourses();
        ArrayList<TechnicalElectiveCourse> technicalElectives = json.readTechnicalElectiveCourse();

        for (int i = 0; i < mandatoryCourses.size(); i++) {
            MandatoryCourse mandatoryCourse = mandatoryCourses.get(i);
            if (mandatoryCourse.getLecturer().getUsername().equals(this.getUsername())) {
                courses.add(mandatoryCourse);
            }
        }
        for (int i = 0; i < nonTechnicalElectives.size(); i++) {
            NonTechnicalElectiveCourse nonTechnicalElective = nonTechnicalElectives.get(i);
            if (nonTechnicalElective.getLecturer().getUsername().equals(this.getUsername())) {
                courses.add(nonTechnicalElective);
            }
        }
        for (int i = 0; i < technicalElectives.size(); i++) {
            TechnicalElectiveCourse technicalElective = technicalElectives.get(i);
            if (technicalElective.getLecturer().getUsername().equals(this.getUsername())) {
                courses.add(technicalElective);
            }
        }
        return courses;
    }

    public boolean addlecturedCourses(Course course) {
        Json json = new Json();
        if (course instanceof MandatoryCourse) {
            ArrayList<MandatoryCourse> mandatoryCourses = json.readMandatoryCourses();
            for (int i = 0; i < mandatoryCourses.size(); i++) {
                MandatoryCourse mandatoryCourse = mandatoryCourses.get(i);
                if (mandatoryCourse.getShortName().equals(course.getShortName())) {
                    mandatoryCourse.setLecturer(this);
                    json.writeMandatoryCourses(mandatoryCourses);
                    return true;
                }
            }

        } else if (course instanceof NonTechnicalElectiveCourse) {
            ArrayList<NonTechnicalElectiveCourse> nonTechnicalElectives = json.readNonTechnicalElectiveCourses();
            for (int i = 0; i < nonTechnicalElectives.size(); i++) {
                NonTechnicalElectiveCourse nonTechnicalElective = nonTechnicalElectives.get(i);
                if (nonTechnicalElective.getShortName().equals(course.getShortName())) {
                    nonTechnicalElective.setLecturer(this);
                    json.writeNonTechnicalElectiveCourse(nonTechnicalElectives);
                    return true;
                }
            }
        } else if (course instanceof TechnicalElectiveCourse) {
            ArrayList<TechnicalElectiveCourse> technicalElectives = json.readTechnicalElectiveCourse();
            for (int i = 0; i < technicalElectives.size(); i++) {
                TechnicalElectiveCourse technicalElective = technicalElectives.get(i);
                if (technicalElective.getShortName().equals(course.getShortName())) {
                    technicalElective.setLecturer(this);
                    json.writeTechnicalElectiveCourse(technicalElectives);
                    return true;
                }
            }

        }
        return false;
    }

    public boolean deletLecturedCourses(Course course) {
        // it don't check the lecturer of course
        Json json = new Json();
        if (course instanceof MandatoryCourse) {
            ArrayList<MandatoryCourse> mandatoryCourses = json.readMandatoryCourses();
            for (int i = 0; i < mandatoryCourses.size(); i++) {
                MandatoryCourse mandatoryCourse = mandatoryCourses.get(i);
                if (mandatoryCourse.getShortName().equals(course.getShortName())) {
                    mandatoryCourses.remove(i);
                    json.writeMandatoryCourses(mandatoryCourses);
                    return true;
                }
            }

        } else if (course instanceof NonTechnicalElectiveCourse) {
            ArrayList<NonTechnicalElectiveCourse> nonTechnicalElectives = json.readNonTechnicalElectiveCourses();
            for (int i = 0; i < nonTechnicalElectives.size(); i++) {
                NonTechnicalElectiveCourse nonTechnicalElective = nonTechnicalElectives.get(i);
                if (nonTechnicalElective.getShortName().equals(course.getShortName())) {
                    nonTechnicalElectives.remove(i);
                    json.writeNonTechnicalElectiveCourse(nonTechnicalElectives);
                    return true;
                }
            }
        } else if (course instanceof TechnicalElectiveCourse) {
            ArrayList<TechnicalElectiveCourse> technicalElectives = json.readTechnicalElectiveCourse();
            for (int i = 0; i < technicalElectives.size(); i++) {
                TechnicalElectiveCourse technicalElective = technicalElectives.get(i);
                if (technicalElective.getShortName().equals(course.getShortName())) {
                    technicalElectives.remove(i);
                    json.writeTechnicalElectiveCourse(technicalElectives);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Student> viewEnrolledStudents(Course course) {
        Json json = new Json();
        ArrayList<Student> students = json.readStudents();
        ArrayList<Student> enrolledStudents = new ArrayList<Student>();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            ArrayList<Course> selectedCourses = student.getSelectedCourses();
            for (int j = 0; j < selectedCourses.size(); j++) {
                Course selectedCourse = selectedCourses.get(j);
                if (selectedCourse.getShortName().equals(course.getShortName())) {
                    if (selectedCourse instanceof MandatoryCourse
                            || selectedCourse instanceof TechnicalElectiveCourse
                            || selectedCourse instanceof NonTechnicalElectiveCourse) {
                        if (((SectionInterface) selectedCourse).getLecturer().getUsername()
                                .equals(this.getUsername())) {
                            enrolledStudents.add(student);
                        }
                    }
                }
            }
        }
        return enrolledStudents;
    }
}
