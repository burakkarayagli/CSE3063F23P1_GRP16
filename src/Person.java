package src;
public abstract class Person {

    private int personID;
    private String personName;
    private String personSurname;
    private String username;
    private String password;

    public int getPersonID() {
        return personID;
    }

    public Person(int personID, String personName, String personSurname, String username, String password) {
        this.personID = personID;
        this.personName = personName;
        this.personSurname = personSurname;
        this.username = username;
        this.password = password;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(int personName) {
        personName = personName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
