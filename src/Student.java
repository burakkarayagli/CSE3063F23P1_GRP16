import java.util.List;

public class Student extends Person {
    private String address;
    private String phoneNumber;
    private int studentYear;
    private int entranceYear;
    private List<Course> courses;


    public Student(int personID, String personName, String personSurname, String username, String password,
                   String address, String phoneNumber, int studentYear, int entranceYear, List<Course> courses) {
        super(personID, personName, personSurname, username, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.studentYear = studentYear;
        this.entranceYear = entranceYear;
        this.courses = courses;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(int studentYear) {
        this.studentYear = studentYear;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(int entranceYear) {
        this.entranceYear = entranceYear;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getFullName(){
        return this.getPersonName()+ " "+this.getPersonSurname();
    }
}
