package models;

import java.util.ArrayList;

import interfaces.SectionInterface;

public class NonTechnicalElectiveCourse extends Course implements SectionInterface {
    private ArrayList<TimeInterval> dates;
    private String sectionName;
    private Lecturer lecturer;
    private int quota;
    private String location;
    private boolean isRemote;

    public NonTechnicalElectiveCourse(Course course, ArrayList<TimeInterval> dates, String sectionName,
            Lecturer lecturer,
            int quota,
            String location, boolean isRemote) {
        super(course.getShortName(), course.getFullName(), course.getDescription(), course.getPrerequisite(),
                course.getSemester(), course.getCredit(), course.getClassHours());
        this.dates = dates;
        this.sectionName = sectionName;
        this.lecturer = lecturer;
        this.quota = quota;
        this.location = location;
        this.isRemote = isRemote;

    }

    public NonTechnicalElectiveCourse(String shortName, String fullName, String description,
            ArrayList<String> prerequisite,
            int semester,
            int credit, int classHours, ArrayList<TimeInterval> dates, String sectionName, Lecturer lecturer,
            int quota, String location, boolean isRemote) {
        super(shortName, fullName, description, prerequisite, semester, credit, classHours);
        this.dates = dates;
        this.sectionName = sectionName;
        this.lecturer = lecturer;
        this.quota = quota;
        this.location = location;
        this.isRemote = isRemote;
    }

    // Interface Methods
    public boolean isTechnical() {
        return false;
    }

    public boolean isMandatory() {
        return false;
    }

    public void setDates(ArrayList<TimeInterval> dates) {
        this.dates = dates;
    }

    public ArrayList<TimeInterval> getDates() {
        return dates;
    }

    // be carefull, same date in memory can have different references
    public boolean addDate(TimeInterval date) {
        this.dates.add(date);
        return true;
    }

    public boolean removeDate(TimeInterval date) {
        this.dates.remove(date);
        return true;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    // Abstract Methods
    public String toString() {
        return "Non Technical Elective Course: " + this.getFullName() + "\nCode: " + this.getShortName() + "\nDescription:"
                + this.getDescription()
                + "\nPrequisite: " + this.getPrerequisities()+ "\nSemester: " + this.getSemester() + "\nCredit: "
                + this.getCredit() + "\nClass Hours: " + this.getClassHours() + "\nSection Name: "
                + this.getSectionName() + "\nLecturer: " + this.getLecturer().getFullName() + "\nQuota: " + this.getQuota()
                + "\nLocation: " + this.location + "\nIsRemote: " + this.isRemote+"\n------------";
    }

    // Class Methods

}
