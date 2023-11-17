import java.util.ArrayList;
import java.util.Scanner;

public class CLI {

    public static void main(String[] args) {
        // Create a new system controller with null logged in user
        SystemController systemController = new SystemController();
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        String_Constants StringConstants = new String_Constants();
        // While there is no logged in user, ask for username and password
        // while (systemController.getLoggedInUser() == null) {
        // System.out.println(StringConstants.WELCOME_MESSAGE);
        // System.out.println(StringConstants.LOGIN_MESSAGE);
        // System.out.print(StringConstants.USERNAME_MESSAGE);
        // String username = scanner.nextLine();
        // System.out.print(StringConstants.PASSWORD_MESSAGE);
        // String password = scanner.nextLine();
        // // If the username and password are correct, authenticate the user and set
        // the
        // // logged in user
        // boolean isLoged = systemController.Authenticate(username, password);
        // if (isLoged) {
        // System.out.println(StringConstants.LOGIN_SUCCESSFUL_MESSAGE);
        // } else {
        // System.out.println(StringConstants.LOGIN_UNSUCCESSFUL_MESSAGE);
        // }
        // System.out.println();
        // }

        menu.Menu();
        // Print the menu for the logged in user
        // System.out.println(systemController.getMenu());
        // // Get the user's selection
        // int selection = scanner.nextInt();

        // if (systemController.getLoggedInUser() instanceof Student) {
        // menu.studentMenu(selection);

        // Student student = (Student) systemController.getLoggedInUser();
        // if (selection == 1) {
        // System.out.println("AVAILABLE COURSES THAT STUDENT CAN TAKE");
        // ArrayList<CourseSection> untakenCourses =
        // systemController.getUntakenCourses(student);
        // for (int i = 0; i < untakenCourses.size(); i++) {
        // CourseSection courseSection = untakenCourses.get(i);
        // System.out.println(i + 1 + ". " + courseSection.getFullName() + " " +
        // courseSection.getSectionName()
        // + " " + courseSection.getShortName());
        // }

        // Scanner input = new Scanner(System.in);
        // System.out.println("You are able to choose one of the courses above.");
        // System.out.print(
        // "Please enter the number of the course you want to choose(Enter -1 if you
        // want to not choose any course): ");
        // int i = input.nextInt();
        // if (i == -1)
        // return;
        // if (systemController.canTakeCourse(student, untakenCourses.get(i - 1))) {
        // systemController.applyCourse(student, untakenCourses.get(i - 1));
        // } else {
        // System.out.println("You can't take this course. You have to take the
        // prerequisites first.");
        // }

        // } else if (selection == 2) {
        // student.printTranscriptInfo();
        // } else if (selection == 3) {
        // }

        // } else if (systemController.getLoggedInUser() instanceof Advisor) {
        // menu.advisorMenu();

        // Advisor advisor = (Advisor) systemController.getLoggedInUser();

        // if (selection == 1) {
        // System.out.println("Which student do you want to go on?");

        // for (int j = 0; j < advisor.getStudents().size(); j++) {
        // System.out.println((j + 1) + "- " +
        // advisor.getStudents().get(j).getFullName());
        // }
        // int studentSelection = scanner.nextInt();
        // System.out.println(
        // "List of courses for student " + advisor.getStudents().get(studentSelection -
        // 1).getFullName());

        // // ArrayList<CourseSection> coursesOfStudent = systemController
        // // .getUntakenCourses(advisor.getStudents().get(studentSelection - 1));
        // // for (int i = 0; i < coursesOfStudent.size(); i++) {
        // // CourseSection courseSection = coursesOfStudent.get(i);
        // // System.out.println(courseSection.getFullName() + " " +
        // // courseSection.getSectionName()
        // // + " " + courseSection.getShortName());
        // // }

        // ArrayList<CourseSection> coursesOfStudent =
        // advisor.getStudents().get(studentSelection - 1)
        // .getCourses();
        // for (int i = 0; i < coursesOfStudent.size(); i++) {
        // CourseSection courseSection = coursesOfStudent.get(i);
        // System.out.println(courseSection.getFullName() + " " +
        // courseSection.getSectionName()
        // + " " + courseSection.getShortName());
        // }

        // System.out.println("1-Approve selections\n2-Reject selections");
        // int decision = scanner.nextInt();

        // if (decision == 1) {
        // // System.out.println(advisor.getStudents().get(studentSelection -
        // // 1).getApproved());
        // advisor.getStudents().get(studentSelection - 1).setApproved(true);
        // // System.out.println(advisor.getStudents().get(studentSelection -
        // // 1).getApproved());
        // }

        // } else if (selection == 2) {
        // System.out.println("Which student do you want to go on?");

        // for (int j = 0; j < advisor.getStudents().size(); j++) {
        // System.out.println((j + 1) + "- " +
        // advisor.getStudents().get(j).getFullName());
        // }
        // int studentSelection = scanner.nextInt();

        // advisor.getStudents().get(studentSelection - 1).printTranscriptInfo();
        // }
        // } else if (systemController.getLoggedInUser() instanceof Lecturer) {
        // menu.lecturerMenu();

        // Lecturer lecturer = (Lecturer) systemController.getLoggedInUser();

        // if (selection == 1) {
        // System.out.println(lecturer.getCourses().get(0).getCourseInfo());

        // }
        // }

    }

}
