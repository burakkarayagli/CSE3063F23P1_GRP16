
import java.util.ArrayList;

public class CourseSection extends Course {

    private ArrayList<TimeInterval> dates;
    private String sectionName;
    private Lecturer lecturer;
    private int quota;

    public CourseSection(String shortName, String fullName, String description, ArrayList<TimeInterval> dates, String sectionName, Lecturer lecturer, int quota) {
        super(shortName, fullName, description);
        this.dates = dates;
        this.sectionName = sectionName;
        this.lecturer = lecturer;
        this.quota = quota;
    }

    public CourseSection(String shortName, String fullName, ArrayList<TimeInterval> dates, String sectionName, Lecturer lecturer, int quota) {
        super(shortName, fullName);
        this.dates = dates;
        this.sectionName = sectionName;
        this.lecturer = lecturer;
        this.quota = quota;
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

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota; 
    }

    public boolean addDate(TimeInterval date) {
        return this.dates.add(date);
    }

    public boolean removeDate(TimeInterval date) {
        return this.dates.remove(date);
    }

    public String getCourseSectionInfo() {
        return "CourseSection{" + "dates=" + dates + ", sectionName=" + sectionName + ", lecturer=" + lecturer + ", quota=" + quota + '}';
    }
}
