import java.util.ArrayList;

public class Course {
    private String shortName;
    private String fullName;
    private String description;
    private ArrayList<String> prerequisite;
    private int semester;
    private int credit;
    private int classHours;

    public Course(String shortName, String fullName, String description, ArrayList<String> prerequisite, int semester,
            int credit, int classHours) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.description = description;
        this.prerequisite = prerequisite;
        this.semester = semester;
        this.credit = credit;
        this.classHours = classHours;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(ArrayList<String> prerequist) {
        this.prerequisite = prerequist;

    }

    public boolean removePrerequisite(String prerequisite) {
        this.prerequisite.remove(prerequisite);
        return true;
    }

    public boolean addPrerequisite(String prerequisite) {
        this.prerequisite.add(prerequisite);
        return true;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if (credit > 0 && credit < 10) {
            this.credit = credit;
        } else {
            System.out.println("Credit must be between 1 and 9");
        }
    }

    public int getClassHours() {
        return classHours;
    }

    public void setClassHours(int classHours) {
        if (classHours > 0 && classHours < 10) {
            this.classHours = classHours;
        } else {
            System.out.println("Class hours must be between 1 and 9");
        }
    }

    public String toString() {
        return "Course Code: " + this.shortName + "\nCourse Name:" + this.fullName + "\nDescription: "
                + this.description + "\nPrerequisite: " + this.prerequisite + "\nSemester: " + this.semester
                + "\nCredit: " + this.credit + "\nClass Hours: " + this.classHours;
    };

}
