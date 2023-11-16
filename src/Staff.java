package src;
public class Staff extends Person {
    private String reputation;
    private int officeHours;
    private int salary;
    private String employmentStatus;

    public Staff(String personName, String personSurname, String username, String password,
            String reputation, int officeHours, int salary, String employmentStatus) {
        super(personName, personSurname, username, password);
        this.reputation = reputation;
        this.officeHours = officeHours;
        this.salary = salary;
        this.employmentStatus = employmentStatus;
    }

    public String getReputation() {
        return this.reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public int getOfficeHours() {
        return this.officeHours;
    }

    public void setOfficeHours(int officeHours) {
        this.officeHours = officeHours;
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
