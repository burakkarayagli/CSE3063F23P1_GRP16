import java.util.ArrayList;
import java.util.List;

public class SystemController {
    private Person loggedInUser;
    private ArrayList<Course> courses;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<CourseSection> courseSections;
    private ArrayList<Student> students;
    private ArrayList<Advisor> advisors;
    private Json json;

    SystemController() {
        json = new Json();
        courses = json.getCourses();
        lecturers = json.getLecturers();
        courseSections = json.getCourseSections();
        students = json.getStudents();
        advisors = json.getAdvisors();

    }

    public SystemController(Person loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Person getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Person loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public ArrayList<CourseSection> getCourseSectionList() {
        return courseSections;
    }

    public ArrayList<Advisor> getAdvisorList() {
        return advisors;
    }

    public ArrayList<Lecturer> getLecturerList() {
        return lecturers;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public boolean Authenticate(String username, String password) {
        // Check if username and password are correct
        // If correct, set loggedInUser to the correct user
        // If incorrect, throw an error
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getUsername().equals(username) && students.get(i).getPassword().equals(password)) {
                this.loggedInUser = students.get(i);
            }
        }
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).getUsername().equals(username) && lecturers.get(i).getPassword().equals(password)) {
                this.loggedInUser = lecturers.get(i);
            }
        }
        for (int i = 0; i < advisors.size(); i++) {
            if (advisors.get(i).getUsername().equals(username) && advisors.get(i).getPassword().equals(password)) {
                this.loggedInUser = advisors.get(i);
            }
        }
        if (this.loggedInUser == null) {
            return false;
        }
        return true;
    }

    public String getMenu() {
        String_Constants StringConstants = new String_Constants();
        if (loggedInUser instanceof Student) {
            return StringConstants.STUDENT_MENU_OPTIONS;
        } else if (loggedInUser instanceof Advisor) {
            return StringConstants.ADVISOR_MENU_OPTIONS;
        } else if (loggedInUser instanceof Lecturer) {
            return StringConstants.LECTURER_MENU_OPTIONS;
        } else {
            return "Error: Invalid user type.";
        }
    }

    public ArrayList<Course> requestCourses() {
        // Return a list of courses for the logged in user
        return null;
    }

    public void printAvailableCourses(Student student) {
        for (int i = 0; i < courses.size(); i++) {
            ArrayList<Grade> studentCoursesTaken = student.getTranscript().getGradeList();
            int j = 0;
            for (; j < studentCoursesTaken.size(); j++) {
                if (studentCoursesTaken.get(j).getCourse().getFullName().equals(courses.get(i).getFullName())) {
                    break;
                }
            }
            if (j == studentCoursesTaken.size()) {
                System.out.println(courses.get(i).getFullName());

            }
        }
    }

    public void printLecturerCourses(Lecturer lecturer) {
        for (int i = 0; i < courses.size(); i++) {
            List<Course> lecturerCourses = lecturer.getCourses();
            int j = 0;
            for (; j < lecturerCourses.size(); j++) {
                if (lecturerCourses.get(j).getShortName().equals(courses.get(i).getShortName())) {
                    System.out.println(lecturerCourses.get(j).getFullName());
                }
            }
        }
    }

    public void printLecturerStudents(Lecturer lecturer) {
        for (int i = 0; i < students.size(); i++) {
            List<Course> lecturerCourses = lecturer.getCourses();
            for (int j = 0; j < students.get(i).getCourses().size(); j++) {
                for (int k = 0; k < lecturerCourses.size(); k++) {
                    System.out.println("Lecturer Course: " + lecturerCourses.get(k).getFullName());
                    System.out.println("Student Course: " + students.get(i).getCourses().get(j).getFullName());
                    if (lecturerCourses.get(k)
                            .equals(students.get(i).getCourses().get(j))) {
                        System.out.println(students.get(i).getCourses().get(k).getFullName());
                    }
                }
            }
        }
    }

    public void printLecturerStudentsGrades(Lecturer lecturer) {
        for (int i = 0; i < courseSections.size(); i++) {

        }
    }

    public void printStudentCourses(Student student) {
        ArrayList<CourseSection> studentCourses = student.getCourses();
        for (int i = 0; i < studentCourses.size(); i++) {
            System.out.println((i + 1) + ". " + studentCourses.get(i).getFullName() + " "
                    + studentCourses.get(i).getSectionName());

        }
    }

    public boolean isUntaken(Student student, CourseSection courseSection) {
        ArrayList<Grade> studentCoursesTaken = student.getTranscript().getGradeList();

        for(int i = 0;i<studentCoursesTaken.size();i++){
            if(studentCoursesTaken.get(i).getCourse().getFullName().equals(courseSection.getFullName()))
                return false;
        }           
       
        return true;
    }

    // Checking if the student passed the prerequisite course.
    public boolean canTakeCourse(Student student, CourseSection courseSection) {
        ArrayList<Grade> grades = student.getTranscript().getGradeList();
        String courseSectionShortName = courseSection.getShortName();

        // Check if the student has taken CSE1241 for CSE1242 course. Computer
        // programming 2 and computer programming 1
        if (courseSectionShortName.equals("CSE1242")) {
            // Check if the student has taken CSE1241
            for (int i = 0; i < grades.size(); i++) {
                if (grades.get(i).getCourse().getShortName().equals("CSE1241")
                        && !grades.get(i).getGrade().equals("FF"))
                    return true;
            }

            // Check if the student has taken MATH1001 for MATH2256 course. Linear algebra
            // and calculus 2.
        } else if (courseSectionShortName.equals("MATH2256")) {
            // Check if the student has taken MATH1002
            for (int i = 0; i < grades.size(); i++) {
                if (grades.get(i).getCourse().getShortName().equals("MATH1002")
                        && !grades.get(i).getGrade().equals("FF"))
                    return true;

            }
        }

        // Check if the student has taken CSE2225 for CSE2246 course. Analysis of
        // algorithms and data structures
        else if (courseSectionShortName.equals("CSE2246")) {
            // Check if the student has taken CSE2225
            for (int i = 0; i < grades.size(); i++) {
                if (grades.get(i).getCourse().getShortName().equals("CSE2225")
                        && !grades.get(i).getGrade().equals("FF"))
                    return true;

            }
        }

        else {
            return true;
        }

        return false;
    }

    // Applying the course operation
    public void applyCourse(Student student, CourseSection courseSection) {
        student.getCourses().add(courseSection);
        json.updateStudents();
        json.updateParametes();

    }

    public void rejectCourse(Advisor advisor, int studentSelection) {
        advisor.getStudents().get(studentSelection - 1).getCourses().clear();
        json.updateStudents();
        json.updateParametes();
    }

    public void approveCourse(Advisor advisor, int studentSelection) {
        advisor.getStudents().get(studentSelection - 1).setApproved(true);
        json.updateStudents();
        json.updateParametes();
    }

    public ArrayList<CourseSection> getAvailableCourses(Student student) {
        ArrayList<CourseSection> availableCourses = new ArrayList<CourseSection>();

        // From the course section list
        for (int i = 0; i < courseSections.size(); i++) {
            CourseSection courseSection = courseSections.get(i);
            if (checkStudentAlreadyAddedTheCourse(student, courseSection) == false
                    && checkPrerequisite(student, courseSection) == true
                    && checkYear(student, courseSection) == true && isUntaken(student, courseSection)) {
                availableCourses.add(courseSection);
            }
        }
        return availableCourses;
    }

    // Function for checking if the student has already added the course.
    public boolean checkStudentAlreadyAddedTheCourse(Student student, CourseSection courseSection) {
        ArrayList<CourseSection> courses = student.getCourses();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getShortName().equals(courseSection.getShortName())) {
                return true;
            }
        }
        return false;
    }

    // If the student has taken the prerequisite course, it will return true.
    public boolean checkPrerequisite(Student student, CourseSection courseSection) {
        ArrayList<Grade> grades = student.getTranscript().getGradeList();
        // If there are no prerequisites, return true.
        if (courseSection.getPrerequisite().equals("")) {
            return true;
        }

        // If there are prerequisites, check if the student has taken the prerequisite
        // course.
        else {
            // Check if the student has taken the prerequisite course. If the student has
            // taken the course, return true.
            // If the student has not taken the course, return false.
            // If the student has taken the course but failed, return false.
            for (int i = 0; i < grades.size(); i++) {
                if (grades.get(i).getCourse().getShortName().equals(courseSection.getPrerequisite())
                        && !grades.get(i).getGrade().equals("FF")) {
                    return true;
                }
            }
            return false;
        }
    }

    // Function for checking if the student's year is suitable for the course.
    public boolean checkYear(Student student, CourseSection courseSection) {

        String courseShortName = courseSection.getShortName();
        int courseYear = parseYearFromShortName(courseShortName);

        // If the student's year is suitable for the course, return true.
        // If the student's year is not suitable for the course, return false.
        if (student.getStudentYear() >= courseYear) {
            return true;
        } else {
            return false;
        }
    }

    // Function for parsing the year from the course short name.
    public int parseYearFromShortName(String courseShortName) {
        // Find first number in string
        int i = 0;
        while (!Character.isDigit(courseShortName.charAt(i))) {
            i++;
        }
        // Return courseShortName.charAt(i) as an int
        return Character.getNumericValue(courseShortName.charAt(i));
    }

    public void save() {
        json.updateStudents();
        json.updateParametes();

    }

    // Accepting or rejecting the course application.

    // Displaying the information of the advisor. It may be more specific depending
    // on request type

    // Possible scenarios

    // Sending the chosen courses to advisor. It will add these courses to the lsit
    // temporarily.
    // Depdending on the action of the advisor, course will stay in the list or not.

    // Deleting the target courses.

    // Displaying the information of the student. It may be more specific depending
    // on request type

    /*
     * public void sendCourses(Course course){
     * student.getCourses().add(course);
     * 
     * // Student list will be inserted to the json file(to the corresponding course
     * list of the student in json file) for the necessary fields.
     * }
     * 
     * public void deleteCourses(Course course){
     * // Similar approach with sendCourses is intended.
     * }
     */
}