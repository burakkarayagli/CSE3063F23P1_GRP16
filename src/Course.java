public class Course {
    private String shortName;
    private String fullName;
    private String description;

    public Course(String shortName, String fullName, String description) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.description = description;
    }

    public Course(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
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

    public String getCourseInfo() {
        return "Course{" + "shortName=" + shortName + ", fullName=" + fullName + ", description=" + description + '}';
    }
}
