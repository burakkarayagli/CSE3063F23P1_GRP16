
import java.util.ArrayList;
import java.util.List;

public class Lecturer extends Staff {
    private transient List<Course> courses = new ArrayList<>();

    public Lecturer(String personName, String personSurname, String username, String password,
            String reputation, ArrayList<TimeInterval> officeHours, int salary, String employmentStatus,
            List<Course> courses) {
        super(personName, personSurname, username, password, reputation, officeHours, salary,
                employmentStatus);
        this.courses = courses;
    }

    private void initCourses() {
        Json json = new Json();
        ArrayList<Course> courses = new ArrayList<>();
        courses.addAll(json.readMandatoryCourses());
        courses.addAll(json.readTechnicalElectiveCourse());
        courses.addAll(json.readNonTechnicalElectiveCourses());
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if (course instanceof SectionInterface) {
                if (((SectionInterface) course).getLecturer().getUsername().equals(this.getUsername())) {
                    boolean isExist = false;
                    // check the already have or not.
                    for (int j = 0; j < this.courses.size(); j++) {
                        Course course1 = this.courses.get(j);
                        if (course1.getShortName().equals(course.getShortName()) && (((SectionInterface) course1)
                                .getSectionName().equals(((SectionInterface) course).getSectionName()))) {
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        this.courses.add(course);
                    }
                }
            }
        }
    }

    public List<Course> getLecturedCourses() {
        // Json json = new Json();
        // ArrayList<Course> courses = new ArrayList<>();
        // ArrayList<MandatoryCourse> mandatoryCourses = json.readMandatoryCourses();
        // ArrayList<NonTechnicalElectiveCourse> nonTechnicalElectives =
        // json.readNonTechnicalElectiveCourses();
        // ArrayList<TechnicalElectiveCourse> technicalElectives =
        // json.readTechnicalElectiveCourse();

        // for (int i = 0; i < mandatoryCourses.size(); i++) {
        // MandatoryCourse mandatoryCourse = mandatoryCourses.get(i);
        // if (mandatoryCourse.getLecturer().getUsername().equals(this.getUsername())) {
        // courses.add(mandatoryCourse);
        // }
        // }
        // for (int i = 0; i < nonTechnicalElectives.size(); i++) {
        // NonTechnicalElectiveCourse nonTechnicalElective =
        // nonTechnicalElectives.get(i);
        // if
        // (nonTechnicalElective.getLecturer().getUsername().equals(this.getUsername()))
        // {
        // courses.add(nonTechnicalElective);
        // }
        // }
        // for (int i = 0; i < technicalElectives.size(); i++) {
        // TechnicalElectiveCourse technicalElective = technicalElectives.get(i);
        // if (technicalElective.getLecturer().getUsername().equals(this.getUsername()))
        // {
        // courses.add(technicalElective);
        // }
        // }
        // return courses;

        // Alternative
        initCourses();
        return this.courses;
    }

    public boolean addlecturedCourses(Course course) {
        // Json json = new Json();
        // if (course instanceof MandatoryCourse) {
        // ArrayList<MandatoryCourse> mandatoryCourses = json.readMandatoryCourses();
        // for (int i = 0; i < mandatoryCourses.size(); i++) {
        // MandatoryCourse mandatoryCourse = mandatoryCourses.get(i);
        // if (mandatoryCourse.getShortName().equals(course.getShortName())) {
        // mandatoryCourse.setLecturer(this);
        // json.writeMandatoryCourses(mandatoryCourses);
        // return true;
        // }
        // }

        // } else if (course instanceof NonTechnicalElectiveCourse) {
        // ArrayList<NonTechnicalElectiveCourse> nonTechnicalElectives =
        // json.readNonTechnicalElectiveCourses();
        // for (int i = 0; i < nonTechnicalElectives.size(); i++) {
        // NonTechnicalElectiveCourse nonTechnicalElective =
        // nonTechnicalElectives.get(i);
        // if (nonTechnicalElective.getShortName().equals(course.getShortName())) {
        // nonTechnicalElective.setLecturer(this);
        // json.writeNonTechnicalElectiveCourse(nonTechnicalElectives);
        // return true;
        // }
        // }
        // } else if (course instanceof TechnicalElectiveCourse) {
        // ArrayList<TechnicalElectiveCourse> technicalElectives =
        // json.readTechnicalElectiveCourse();
        // for (int i = 0; i < technicalElectives.size(); i++) {
        // TechnicalElectiveCourse technicalElective = technicalElectives.get(i);
        // if (technicalElective.getShortName().equals(course.getShortName())) {
        // technicalElective.setLecturer(this);
        // json.writeTechnicalElectiveCourse(technicalElectives);
        // return true;
        // }
        // }

        // }
        // return false;

        // Alternative
        ((SectionInterface) course).setLecturer(this);
        Json json = new Json();
        if (course instanceof MandatoryCourse) {
            ArrayList<MandatoryCourse> courses = json.readMandatoryCourses();
            courses.add((MandatoryCourse) course);
            json.writeMandatoryCourses(courses);
        } else if (course instanceof TechnicalElectiveCourse) {
            ArrayList<TechnicalElectiveCourse> courses = json.readTechnicalElectiveCourse();
            courses.add((TechnicalElectiveCourse) course);
            json.writeTechnicalElectiveCourse(courses);
        } else if (course instanceof NonTechnicalElectiveCourse) {
            ArrayList<NonTechnicalElectiveCourse> courses = json.readNonTechnicalElectiveCourses();
            courses.add((NonTechnicalElectiveCourse) course);
            json.writeNonTechnicalElectiveCourse(courses);
        }
        initCourses();
        return true;

    }

    public boolean deletLecturedCourses(Course course) {
        // it don't check the lecturer of course
        // Json json = new Json();
        // if (course instanceof MandatoryCourse) {
        // ArrayList<MandatoryCourse> mandatoryCourses = json.readMandatoryCourses();
        // for (int i = 0; i < mandatoryCourses.size(); i++) {
        // MandatoryCourse mandatoryCourse = mandatoryCourses.get(i);
        // if (mandatoryCourse.getShortName().equals(course.getShortName())) {
        // mandatoryCourses.remove(i);
        // json.writeMandatoryCourses(mandatoryCourses);
        // return true;
        // }
        // }

        // } else if (course instanceof NonTechnicalElectiveCourse) {
        // ArrayList<NonTechnicalElectiveCourse> nonTechnicalElectives =
        // json.readNonTechnicalElectiveCourses();
        // for (int i = 0; i < nonTechnicalElectives.size(); i++) {
        // NonTechnicalElectiveCourse nonTechnicalElective =
        // nonTechnicalElectives.get(i);
        // if (nonTechnicalElective.getShortName().equals(course.getShortName())) {
        // nonTechnicalElectives.remove(i);
        // json.writeNonTechnicalElectiveCourse(nonTechnicalElectives);
        // return true;
        // }
        // }
        // } else if (course instanceof TechnicalElectiveCourse) {
        // ArrayList<TechnicalElectiveCourse> technicalElectives =
        // json.readTechnicalElectiveCourse();
        // for (int i = 0; i < technicalElectives.size(); i++) {
        // TechnicalElectiveCourse technicalElective = technicalElectives.get(i);
        // if (technicalElective.getShortName().equals(course.getShortName())) {
        // technicalElectives.remove(i);
        // json.writeTechnicalElectiveCourse(technicalElectives);
        // return true;
        // }
        // }
        // }
        // return false;
        Json json = new Json();
        ArrayList<SectionInterface> courses = new ArrayList<>();
        courses.addAll(json.readMandatoryCourses());
        courses.addAll(json.readTechnicalElectiveCourse());
        courses.addAll(json.readNonTechnicalElectiveCourses());
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getLecturer().getUsername()
                    .equals(((SectionInterface) course).getLecturer().getUsername())) {
                if (course instanceof MandatoryCourse) {
                    ArrayList<MandatoryCourse> mCourses = json.readMandatoryCourses();
                    for (int j = 0; j < mCourses.size(); j++) {
                        if (mCourses.get(j).getShortName().equals(course.getShortName()) && mCourses.get(i)
                                .getSectionName().equals(((MandatoryCourse) course).getSectionName())) {
                            mCourses.remove(j);
                        }
                    }
                    ArrayList<TechnicalElectiveCourse> tCourses = json.readTechnicalElectiveCourse();
                    for (int j = 0; j < tCourses.size(); j++) {
                        if (tCourses.get(j).getShortName().equals(course.getShortName()) && tCourses.get(i)
                                .getSectionName().equals(((TechnicalElectiveCourse) course).getSectionName())) {
                            tCourses.remove(j);
                        }
                    }
                    ArrayList<NonTechnicalElectiveCourse> nCourses = json.readNonTechnicalElectiveCourses();
                    for (int j = 0; j < nCourses.size(); j++) {
                        if (nCourses.get(j).getShortName().equals(course.getShortName()) && nCourses.get(i)
                                .getSectionName().equals(((NonTechnicalElectiveCourse) course).getSectionName())) {
                            nCourses.remove(j);
                        }
                    }
                    json.writeMandatoryCourses(mCourses);
                    json.writeTechnicalElectiveCourse(tCourses);
                    json.writeNonTechnicalElectiveCourse(nCourses);
                }
            }
        }
        initCourses();
        return true;

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
