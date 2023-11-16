
import java.util.ArrayList;

public class Student extends Person {
    private String address;
    private String phoneNumber;
    private int studentYear;
    private int entranceYear;
    private boolean isApproved;
    private ArrayList<CourseSection> courses;
    private Transcript transcript;

    public Student(String personName, String personSurname, String username, String password,
            String address, String phoneNumber, int studentYear, int entranceYear, boolean isApproved,
            ArrayList<CourseSection> courses,
            Transcript transcript) {
        super(personName, personSurname, username, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.studentYear = studentYear;
        this.entranceYear = entranceYear;
        this.courses = courses;
        this.transcript = transcript;
    }

    public void printTranscriptInfo(){
        System.out.println("STUDENT TRANSCRIPT");
        System.out.println("-------------------------------------------------");
        System.out.println(transcript.getGrades());
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

    public boolean getApproved() {
        return this.isApproved;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public ArrayList<CourseSection> getCourses() {
        return courses;
    }

    public String getFullName() {
        return this.getPersonName() + " " + this.getPersonSurname();
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

}
