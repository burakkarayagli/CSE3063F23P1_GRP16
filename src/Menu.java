import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    String_Constants StringConstants = new String_Constants();
    StudentMenu studentMenu = new StudentMenu();
    AdvisorMenu advisorMenu = new AdvisorMenu();
    LecturerMenu lecturerMenu = new LecturerMenu();

    private Person loggedInUser;
    private ArrayList<Course> courses;
    private ArrayList<Lecturer> lecturers;
    // private ArrayList<CourseSection> courseSections;
    private ArrayList<Student> students;
    private ArrayList<Advisor> advisors;
    private Json json;

    Menu() {
        json = new Json();
        courses = json.readCourses();
        lecturers = json.readLecturers();
        students = json.readStudents();
        advisors = json.readAdvisors();
        // courseSections = json.getCourseSections();

    }

    public void Menu() {
        Scanner loginScanner = new Scanner(System.in);
        while (getLoggedInUser() == null) {
            System.out.println(StringConstants.WELCOME_MESSAGE);
            System.out.println(StringConstants.LOGIN_MESSAGE);
            System.out.print(StringConstants.USERNAME_MESSAGE);
            String username = loginScanner.nextLine();
            System.out.print(StringConstants.PASSWORD_MESSAGE);
            String password = loginScanner.nextLine();
            // If the username and password are correct, authenticate the user and set the
            // logged in user
            boolean isLogged = Authenticate(username, password);
            if (isLogged) {
                System.out.println(StringConstants.LOGIN_SUCCESSFUL_MESSAGE);
            } else {
                System.out.println(StringConstants.LOGIN_UNSUCCESSFUL_MESSAGE);
            }
            System.out.println();
        }

        // System.out.println(systemController.getMenu());
        // int selection = scanner.nextInt();

        if (getLoggedInUser() instanceof Student) {
            studentMenu.studentMenu();
        } else if (getLoggedInUser() instanceof Advisor) {
            advisorMenu.advisorMenu();
        } else if (getLoggedInUser() instanceof Lecturer) {
            lecturerMenu.lecturerMenu();
        }

    }

    public boolean Authenticate(String username, String password) {
        // Check if username and password are correct
        // If correct, set loggedInUser to the correct user
        // If incorrect, throw an error
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getUsername().equals(username) && students.get(i).getPassword().equals(password)) {
                setLoggedInUser(this.loggedInUser = students.get(i));
            }
        }
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).getUsername().equals(username) && lecturers.get(i).getPassword().equals(password)) {
                setLoggedInUser(lecturers.get(i));
            }
        }
        for (int i = 0; i < advisors.size(); i++) {
            if (advisors.get(i).getUsername().equals(username) && advisors.get(i).getPassword().equals(password)) {
                setLoggedInUser(advisors.get(i));
            }
        }
        if (this.loggedInUser == null) {
            return false;
        }
        return true;
    }

    public Person getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Person loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

}
