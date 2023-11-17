public class Course {
    private String shortName;
    private String fullName;
    private String description;
    private String prerequisite;

    public Course(String shortName, String fullName, String description, String prerequisite) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.description = description;
        this.prerequisite = prerequisite;
    }

    public Course(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.description = "";
        this.prerequisite = "";
    }

    public Course() {
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

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequist) {
        this.prerequisite = prerequist;

    }

    public String getCourseInfo() {
        // return "Course{" + "shortName=" + shortName + ", fullName=" + fullName + ",
        // description=" + description + '}';
        return fullName + " (" + shortName + ") " + description + " " + prerequisite;
    }
}
