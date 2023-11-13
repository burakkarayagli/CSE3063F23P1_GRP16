package src;

import java.util.ArrayList;

public class CourseSection extends Course{

    private int id;
    private ArrayList<TimeInterval> dates;
    private String sectionName;
    private Lecturer lecturer;

    public CourseSection(int id, ArrayList<TimeInterval> dates, String sectionName, Lecturer lecturer) {
        this.id = id;
        this.dates = dates;
        this.sectionName = sectionName;
        this.lecturer = lecturer;
    }

    public CourseSection(int id, ArrayList<TimeInterval> dates, String sectionName) {
        this.id = id;
        this.dates = dates;
        this.sectionName = sectionName;
    }

    public CourseSection(int id, ArrayList<TimeInterval> dates) {
        this.id = id;
        this.dates = dates;
    }

    public CourseSection(int id) {
        this.id = id;
    }

    public CourseSection() {
    }

    public int getId() {
        return id;
    }

    public ArrayList<TimeInterval> getDates() {
        return dates;
    }

    public void setDates(ArrayList<TimeInterval> dates) {
        this.dates = dates;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String section) {
        this.sectionName = section;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public String toString() {
        return "CourseSection{" +
                "id=" + id +
                ", dates=" + dates +
                ", sectionName='" + sectionName + '\'' +
                ", lecturer=" + lecturer +
                '}';
    }
}
