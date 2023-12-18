package menus;

import java.util.ArrayList;
import java.util.Scanner;

import constants.String_Constants;
import contollers.StudentController;
import contollers.LecturerController;
import models.*;
import utils.DataUtils;

public class Menu {

    // Singleton
    private static Menu MenuInstance = null;

    public static Menu getInstance() {
        if (MenuInstance == null) {
            MenuInstance = new Menu();
        }
        return MenuInstance;
    }

    Scanner loginScanner = new Scanner(System.in);

    String_Constants StringConstants = new String_Constants();

    private Person loggedInUser;
    public static ArrayList<Student> students;
    private ArrayList<Advisor> advisors;
    private ArrayList<Lecturer> lecturers;
    private DataUtils json;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.LoginMenu();
    }

    public Menu() {
        loggedInUser = null;
        json = DataUtils.getInstance();
        lecturers = json.readLecturers();
        students = json.readStudents();
        advisors = json.readAdvisors();
    }

    public void LoginMenu() {
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
        PersonMenu();
    }

    public void PersonMenu() {
        if (getLoggedInUser() instanceof Student) {
            StudentMenu studentMenu = new StudentMenu(new StudentController((Student) getLoggedInUser()));
            studentMenu.studentMenu();
        } else if (getLoggedInUser() instanceof Advisor) {
            // advisorMenu.advisorMenu();
        } else if (getLoggedInUser() instanceof Lecturer) {
            LecturerMenu lecturerMenu = new LecturerMenu(new LecturerController((Lecturer) getLoggedInUser()));
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
