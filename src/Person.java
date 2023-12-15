
public abstract class Person {

    private String personName;
    private String personSurname;
    private String username;
    private String password;


    public Person(String personName, String personSurname, String username, String password) {
        this.personName = personName;
        this.personSurname = personSurname;
        this.username = username;
        this.password = password;
    }

    public Person() {
        
    }

    public String getPersonName() {
        return personName;
    }

    public String getFullName(){
        return this.personName+" "+this.personSurname;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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
