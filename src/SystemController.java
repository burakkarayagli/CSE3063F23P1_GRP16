import java.util.ArrayList;
import java.util.List;

public class SystemController {
    private Person loggedInUser;

    public SystemController(Person loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public SystemController() {
    }

    public Person getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Person loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public boolean Authenticate(String username, String password) {
        //Check if username and password are correct
        //If correct, set loggedInUser to the correct user
        //If incorrect, throw an error
        Person dummyUser = new Student(1, "John", "Doe", "johndoe", "password", "123 Main St", "555-555-5555", 1, 2020, null);
        setLoggedInUser(dummyUser);
        return true;
    }

    public String getMenu() {
        if (loggedInUser instanceof Student) {
            return String_Constants.STUDENT_MENU_OPTIONS;
        } 
        else if (loggedInUser instanceof Advisor) {
            return String_Constants.ADVISOR_MENU_OPTIONS;
        }
        else if (loggedInUser instanceof Advisor) {
            return String_Constants.ADVISOR_MENU_OPTIONS;
        }
        else {
            return "Error: Invalid user type.";
        }
    }

    public ArrayList<Course> requestCourses() {
        //Return a list of courses for the logged in user
        return null;
    }

    public String viewCourses() {
        //ArrayList<Course> courses = requestCourses();
        ArrayList<Course> courses = new ArrayList<Course>(
            List.of(
                new Course("CS101", "Introduction to Computer Science", "This course is an introduction to computer science."),
                new Course("CS102", "Introduction to Programming", "This course is an introduction to programming.")
            )
        );

        String courseList = "";
        for (Course course : courses) {
            courseList += course.getShortName() + " - " + course.getFullName() + "\n";
        }
        return courseList;
    }




}
