
import java.util.ArrayList;

public class Student extends Person {
    private String address;
    private String phoneNumber;
    private int semester;
    private int entranceYear;
    private String status; // waiting, approved, rejected, finished, available
    private ArrayList<Course> selectedCourses;
    private Transcript transcript;

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSemester() {
        return this.semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getEntranceYear() {
        return this.entranceYear;
    }

    public void setEntranceYear(int entranceYear) {
        this.entranceYear = entranceYear;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Course> getSelectedCourses() {
        return this.selectedCourses;
    }

    public void setSelectedCourses(ArrayList<Course> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    public Transcript getTranscript() {
        return this.transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public Student(String name, String surname, String id, String password, String address, String phoneNumber,
            int semester, int entranceYear, String status, ArrayList<Course> selectedCourses, Transcript transcript) {
        super(name, surname, id, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.semester = semester;
        this.entranceYear = entranceYear;
        this.status = status;
        this.selectedCourses = selectedCourses;
        this.transcript = transcript;
    }

    public Student() {
        super();
        this.address = "";
        this.phoneNumber = "";
        this.semester = 0;
        this.entranceYear = 0;
        this.status = "";
        this.selectedCourses = new ArrayList<Course>();
        this.transcript = new Transcript();
    }

    // Adding a course to the selected courses of the student
    public boolean addCourse(Course course) {
        try {
            selectedCourses.add(course);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }

    }

    public boolean dropCourse(Course course) {
        try {
            selectedCourses.remove(course);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Course> getAvailableCourses() {
        ArrayList<Course> availableCourses = new ArrayList<Course>();

        ArrayList<Course> allCourse = getAllCourses();
        for (Course course : allCourse) {
            if (studentCanTakeCourse(course)) {
                availableCourses.add(course);
            }
        }

        return availableCourses;
    }

    private boolean studentCanTakeCourse(Course course) {
        if (checkStudentAlreadySelectedCourse(course) == false &&
                checkPrerequisite(course) == true &&
                checkSemesterOfCourse(course) == true &&
                checkStudentPassedCourse(course) == false) {
            return true;
        }

        else {
            return false;
        }
    }

    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> allCourses = new ArrayList<Course>();

        Json json = new Json();
        allCourses.addAll(json.readMandatoryCourses());
        allCourses.addAll(json.readTechnicalElectiveCourse());
        allCourses.addAll(json.readNonTechnicalElectiveCourses());

        return allCourses;
    }

    public String getWarnings() {

        String warningString = "";

        if (checkCreditLimit() == false) {
            warningString += "========Student has exceeded the credit limit.=========\n";
            warningString += "Total credit: " + getTotalCreditOfSelectedCourses() + "\n";
            warningString += "Max credit: 30\n";
            warningString += "========================================================\n";
        }

        // TODO: revise this function after merge
        if (checkOverlappingCourses().size() > 0) {
            warningString += "========Student has overlapping courses.=========\n";
            for (ArrayList<Course> overlappingCourses : checkOverlappingCourses()) {
                warningString += "Overlapping courses: ";
                for (Course course : overlappingCourses) {
                    warningString += course.getFullName() + " (" + course.getShortName() + "), ";
                }
                warningString += "\n";
            }
            warningString += "========================================================\n";
        }

        return warningString;
    }

    private int getTotalCreditOfSelectedCourses() {
        int totalCredit = 0;

        for (Course course : selectedCourses) {
            totalCredit += course.getCredit();
        }

        return totalCredit;
    }

    // Returns true if the student has less than max credit
    public boolean checkCreditLimit() {
        if (getTotalCreditOfSelectedCourses() > 30) {
            return false;
        }

        else {
            return true;
        }
    }

    // Returns true if the student has already selected the course
    public boolean checkStudentAlreadySelectedCourse(Course course) {
        if (selectedCourses.contains(course)) {
            return true;
        }

        else {
            return false;
        }
    }

    // Returns true if the student passed the prerequisite courses
    public boolean checkPrerequisite(Course course) {
        if (course.getPrerequisite().isEmpty()) {
            return true;
        }

        else {
            for (String prerequisite : course.getPrerequisite()) {
                if (checkStudentPassedCourseWithShortName(prerequisite) == false) {
                    return false;
                }
            }

            return true;
        }
    }

    // Returns true if student has greater or equal semester than the course
    public boolean checkSemesterOfCourse(Course course) {
        if (course.getSemester() <= this.semester) {
            return true;
        } else {
            return false;
        }
    }

    // Returns true if the course is in the transcript(student has taken the course
    // before and passed)
    public boolean checkStudentPassedCourse(Course course) {
        for (Grade grade : transcript.getGradeList()) {
            if (grade.getCourse().getShortName().equals(course.getShortName()) && grade.getGrade() != "FF") {
                return true;
            }
        }

        return false;
    }

    public boolean checkStudentPassedCourseWithShortName(String courseShortName) {
        for (Grade grade : transcript.getGradeList()) {
            if (grade.getCourse().getShortName().equals(courseShortName) && grade.getGrade() != "FF") {
                return true;
            }
        }

        return false;
    }

    public void printSelectedCourses() {
        System.out.println("Selected courses of " + getPersonName() + " " + getPersonSurname());
        System.out.println("====================================");
        for (Course course : selectedCourses) {
            System.out.println(course.getFullName() + " (" + course.getShortName() + ")");
        }
        System.out.println("====================================");
    }

    public void printTranscript() {
        System.out.println("Transcript of " + getPersonName() + " " + getPersonSurname());
        System.out.println("====================================");
        for (Grade grade : transcript.getGradeList()) {
            System.out.println(
                    grade.getCourse().getFullName() + " (" + grade.getCourse().getShortName() + "): "
                            + grade.getGrade());
        }
        System.out.println("====================================");
    }

    public boolean sendCoursesForApproval() {
        if (status.equals("waiting")) {
            System.out.println("Error: Student has already sent courses for approval.");
            return false;
        }

        else if (status.equals("finished")) {
            System.out.println("Course registration is finished.");
            return false;
        }

        else {
            setStatus("waiting");
            System.out.println("Courses sent for approval.");
            return true;
        }
    }

    public ArrayList<ArrayList<Course>> checkOverlappingCourses() {
        return new ArrayList<ArrayList<Course>>();
    }
}
