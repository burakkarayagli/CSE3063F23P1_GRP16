package models;

import java.util.ArrayList;

import interfaces.SectionInterface;
import menus.Menu;
import utils.DataUtils;

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

            DataUtils database = DataUtils.getInstance();
            database.writeStudents(Menu.students);
            // Update the advisor's student's selected courses
            ArrayList<Advisor> advisors = database.readAdvisors();
            for (int i = 0; i < advisors.size(); i++) {
                for (int j = 0; j < advisors.get(i).getStudents().size(); j++) {
                    if (advisors.get(i).getStudents().get(j).getUsername().equals(this.getUsername())) {
                        advisors.get(i).getStudents().set(j, this);
                    }
                }
            }
            database.writeAdvisors(advisors);

            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }

    }

    public boolean dropCourse(Course course) {
        try {
            selectedCourses.remove(course);

            DataUtils database = DataUtils.getInstance();
            database.writeStudents(Menu.students);
            // Update the advisor's student's selected courses
            ArrayList<Advisor> advisors = database.readAdvisors();
            for (int i = 0; i < advisors.size(); i++) {
                for (int j = 0; j < advisors.get(i).getStudents().size(); j++) {
                    if (advisors.get(i).getStudents().get(j).getUsername().equals(this.getUsername())) {
                        advisors.get(i).getStudents().set(j, this);
                    }
                }
            }
            database.writeAdvisors(advisors);
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

        DataUtils dataUtils = DataUtils.getInstance();
        allCourses.addAll(dataUtils.readMandatoryCourses());
        allCourses.addAll(dataUtils.readTechnicalElectiveCourse());
        allCourses.addAll(dataUtils.readNonTechnicalElectiveCourses());

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

        if (getOverlappingCourses().size() > 0) {
            warningString += "========Student has overlapping courses.=========\n";
            for (ArrayList<Course> overlappingCourse : getOverlappingCourses()) {
                warningString += overlappingCourse.get(0).getFullName() + " and "
                        + overlappingCourse.get(1).getFullName() + " are overlapping.\n";
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
        // Check if the course's short name is in the selected courses
        for (Course selectedCourse : selectedCourses) {
            if (selectedCourse.getShortName().equals(course.getShortName())) {
                return true;
            }
        }

        return false;
    }

    // Returns true if the student passed the prerequisite courses
    public boolean checkPrerequisite(Course course) {
        if (course.getPrerequisite() == null) {
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

    public ArrayList<ArrayList<Course>> getOverlappingCourses() {
        ArrayList<ArrayList<Course>> overlappingCourses = new ArrayList<ArrayList<Course>>();

        selectedCourses = getSelectedCourses();
        for (int i = 0; i < selectedCourses.size(); i++) {
            for (int j = i + 1; j < selectedCourses.size(); j++) {
                for (TimeInterval timeInterval : ((SectionInterface) selectedCourses.get(i)).getDates()) {
                    for (TimeInterval timeInterval2 : ((SectionInterface) selectedCourses.get(j)).getDates()) {
                        try {
                            if (timeInterval.isOverlapping(timeInterval2)) {
                                ArrayList<Course> overlappingCourse = new ArrayList<Course>();
                                overlappingCourse.add(selectedCourses.get(i));
                                overlappingCourse.add(selectedCourses.get(j));
                                overlappingCourses.add(overlappingCourse);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return overlappingCourses;
    }
}
