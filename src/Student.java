
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

        ArrayList<Course> allCourseSections = getAllCourses();
        for (Course course : allCourseSections) {
            if (checkStudentAlreadySelectedCourse(course) == false &&
                    checkPrerequisite(course) == true &&
                    checkSemesterOfCourse(course) == true) {
                availableCourses.add(course);
            }
        }

        return availableCourses;
    }

    public ArrayList<Course> getAllCourses() {

        Json json = new Json();
        ArrayList<CourseSection> allCourseSections = json.readCourseSections();
        ArrayList<Course> allCourses = new ArrayList<Course>();

        allCourses.addAll(allCourseSections);
        return allCourses;
    }

    public String getWarnings() {

        return "";
    }

    public int getTotalCredit() {

        return 0;
    }

    public boolean checkCredits() {
        return false;
    }

    public boolean checkStudentAlreadySelectedCourse(Course course) {
        return false;
    }

    public boolean checkPrerequisite(Course course) {
        return false;
    }

    public boolean checkSemesterOfCourse(Course course) {
        return false;
    }

    // Returns true if the course is in the transcript(student has taken the course
    // before and passed)
    private boolean checkCourseInTranscript(Course course) {
        for (Grade grade : transcript.getGradeList()) {
            if (grade.getCourse() == course) {
                return true;
            }
        }

        return false;
    }

    public boolean sendCoursesForApproval() {
        return false;
    }

    public ArrayList<ArrayList<Course>> checkOverlapingCourses() {
        ArrayList<ArrayList<Course>> overlapingCourses = new ArrayList<ArrayList<Course>>();

        ArrayList<Course> allCourseSections = getSelectedCourses();

        for(int i = 0; i < allCourseSections.size(); i++) {

            Course course1 = allCourseSections.get(i);
            ArrayList<TimeInterval> dates1 = new ArrayList<>();

            for(int j = i + 1; j < allCourseSections.size(); j++) {

                Course course2 = allCourseSections.get(j);
                ArrayList<TimeInterval> dates2 = new ArrayList<>();

                if(allCourseSections.get(i) instanceof MandatoryCourse) {
                    course1 = (MandatoryCourse) allCourseSections.get(i);
                    dates1 = ((MandatoryCourse) allCourseSections.get(i)).getDates();
                }
                else if(allCourseSections.get(i) instanceof TechnicalElectiveCourse) {
                    course1 = (TechnicalElectiveCourse) allCourseSections.get(i);
                    dates1 = ((TechnicalElectiveCourse) allCourseSections.get(i)).getDates();
                }
                else if(allCourseSections.get(i) instanceof NonTechnicalElectiveCourse) {
                    course1 = (NonTechnicalElectiveCourse) allCourseSections.get(i);
                    dates1 = ((NonTechnicalElectiveCourse) allCourseSections.get(i)).getDates();
                }
                if(allCourseSections.get(j) instanceof MandatoryCourse) {
                    course2 = (MandatoryCourse) allCourseSections.get(i);
                    dates2 = ((MandatoryCourse) allCourseSections.get(i)).getDates();
                }
                else if(allCourseSections.get(j) instanceof TechnicalElectiveCourse) {
                    course2 = (TechnicalElectiveCourse) allCourseSections.get(i);
                    dates2 = ((TechnicalElectiveCourse) allCourseSections.get(i)).getDates();
                }
                else if(allCourseSections.get(j) instanceof NonTechnicalElectiveCourse) {
                    course2 = (NonTechnicalElectiveCourse) allCourseSections.get(i);
                    dates2 = ((NonTechnicalElectiveCourse) allCourseSections.get(i)).getDates();
                }

                for(int x = 0; x < dates1.size(); x++) {
                    if(dates2.contains(dates1.get(x))) {
                    ArrayList<Course> overlapingCourse = new ArrayList<Course>();
                    overlapingCourse.add(course1);
                    overlapingCourse.add(course2);
                    overlapingCourses.add(overlapingCourse);
                }
                }
            }
        }

        return overlapingCourses;
    }

    // + addCourse(course: Course): boolean
    // + dropCourse(course: Course): boolean
    // - dropCourse(course: Course): boolean
    // + getSelectedCourse():
    // + getAvailableCourses():
    // + getAllCourses():
    // + getWarnings(): String
    // - getTotalCredit(): int
    // - checkCredits(): boolean
    // - checkStudentAlreadySelectedCourse(course: Course): boolean
    // - checkPrerequisite(course: Course): boolean
    // - checkSemesterOfCourse(course: Course): boolean
    // + sendCoursesForApproval(): boolean
    // + checkOver1apingCourses(): ArrayList<ArrayList<Course>>
}
