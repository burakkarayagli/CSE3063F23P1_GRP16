import java.util.ArrayList;

public class Staff extends Person {
    private String reputation;
    private ArrayList<TimeInterval> officeHours;
    private int salary;
    private String employmentStatus;
    
    public Staff(String personName, String personSurname, String username, String password,
            String reputation, ArrayList<TimeInterval> officeHours, int salary, String employmentStatus) {
        super(personName, personSurname, username, password);
        this.reputation = reputation;
        this.officeHours = officeHours;
        this.salary = salary;
        this.employmentStatus = employmentStatus;
        this.officeHours = officeHours;
    }

    public void setOfficeHours(ArrayList<TimeInterval> officeHours) {
        this.officeHours = officeHours;
    }

    public Staff() {
        
    }

    public String getReputation() {
        return this.reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public ArrayList<TimeInterval> getOfficeHours() {
        return this.officeHours;
    }
    public boolean addOfficeHours(TimeInterval officeHour){
        return officeHours.add(officeHour);
    }
    public boolean deleteOfficeHours(TimeInterval officeHour){
        return officeHours.remove(officeHour);
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
}
