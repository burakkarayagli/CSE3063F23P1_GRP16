import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    SystemController systemController = new SystemController();
    String_Constants StringConstants = new String_Constants();

    public void Menu() {
        Scanner loginScanner = new Scanner(System.in);
        while (systemController.getLoggedInUser() == null) {
            System.out.println(StringConstants.WELCOME_MESSAGE);
            System.out.println(StringConstants.LOGIN_MESSAGE);
            System.out.print(StringConstants.USERNAME_MESSAGE);
            String username = loginScanner.nextLine();
            System.out.print(StringConstants.PASSWORD_MESSAGE);
            String password = loginScanner.nextLine();
            // If the username and password are correct, authenticate the user and set the
            // logged in user
            boolean isLogged = systemController.Authenticate(username, password);
            if (isLogged) {
                System.out.println(StringConstants.LOGIN_SUCCESSFUL_MESSAGE);
            } else {
                System.out.println(StringConstants.LOGIN_UNSUCCESSFUL_MESSAGE);
            }
            System.out.println();
        }

        // System.out.println(systemController.getMenu());
        // int selection = scanner.nextInt();

        if (systemController.getLoggedInUser() instanceof Student) {
            studentMenu();
        } else if (systemController.getLoggedInUser() instanceof Advisor) {
            advisorMenu();
        } else if (systemController.getLoggedInUser() instanceof Lecturer) {
            lecturerMenu();
        }

    }

    public void studentMenu() {
        System.out.println(systemController.getMenu());
        int selection = scanner.nextInt();

        Student student = (Student) systemController.getLoggedInUser();
        if (selection == 1) {
            System.out.println("AVAILABLE COURSES THAT STUDENT CAN TAKE");
            ArrayList<CourseSection> availableCourses = systemController.getAvailableCourses(student);
            for (int i = 0; i < availableCourses.size(); i++) {
                CourseSection courseSection = availableCourses.get(i);
                System.out.println(i + 1 + ". " + courseSection.getFullName() + " " + courseSection.getSectionName()
                        + " " + courseSection.getShortName());
            }

            Scanner input = new Scanner(System.in);
            System.out.println("You are able to choose one of the courses above.");
            System.out.print(
                    "Please select the course you want to take(Enter -1 if you don't want to choose any course): ");

            int i = input.nextInt();
            if (i == -1)
                studentMenu();
            else {
                try {
                    systemController.applyCourse(student, availableCourses.get(i - 1));
                } catch (Exception e) {
                    System.out.println(StringConstants.INVALID_OPTION_MESSAGE);
                }
            }

        } else if (selection == 2) {
            student.printTranscriptInfo();
        } else if (selection == 3) {
            systemController.setLoggedInUser(null);
        }

        else if (selection == 4) {
            ArrayList<CourseSection> coursesTaken = student.getCourses();

            for (int i = 0; i < coursesTaken.size(); i++) {
                System.out.println(coursesTaken.get(i).getShortName() + " " + coursesTaken.get(i).getFullName() + " "
                        + coursesTaken.get(i).getShortName());
            }
        }

        if (systemController.getLoggedInUser() == null) {
            Menu();
        } else {
            studentMenu();
        }

    }

    public void advisorMenu() {

        System.out.println(systemController.getMenu());
        int selection = scanner.nextInt();

        Advisor advisor = (Advisor) systemController.getLoggedInUser();

        if (selection == 1) {
            System.out.println("Which student do you want to go on?");

            for (int j = 0; j < advisor.getStudents().size(); j++) {
                System.out.println((j + 1) + "- " + advisor.getStudents().get(j).getFullName());
            }
            int studentSelection = scanner.nextInt();
            System.out.println(
                    "List of courses for student " + advisor.getStudents().get(studentSelection - 1).getFullName());

            ArrayList<CourseSection> coursesOfStudent = advisor.getStudents().get(studentSelection - 1)
                    .getCourses();
            for (int i = 0; i < coursesOfStudent.size(); i++) {
                CourseSection courseSection = coursesOfStudent.get(i);
                System.out.println(courseSection.getFullName() + " " +
                        courseSection.getSectionName()
                        + " " + courseSection.getShortName());
            }

            System.out.println("1-Approve selections\n2-Reject selections");
            int decision = scanner.nextInt();

            if (decision == 1) {
                // System.out.println(advisor.getStudents().get(studentSelection -
                // 1).getApproved());
                // advisor.getStudents().get(studentSelection - 1).setApproved(true);
                systemController.approveCourse(advisor, studentSelection);
                // System.out.println(advisor.getStudents().get(studentSelection -
                // 1).getApproved());
            } else if (decision == 2) {
                systemController.rejectCourse(advisor, studentSelection);
                // advisor.getStudents().get(studentSelection - 1).clearCourses();
            }

        } else if (selection == 2) {
            System.out.println("Which student do you want to go on?");

            for (int j = 0; j < advisor.getStudents().size(); j++) {
                System.out.println((j + 1) + "- " + advisor.getStudents().get(j).getFullName());
            }
            int studentSelection = scanner.nextInt();

            advisor.getStudents().get(studentSelection - 1).printTranscriptInfo();
        } else if (selection == 3) {
            systemController.setLoggedInUser(null);
        }

        if (systemController.getLoggedInUser() == null) {
            Menu();
        } else {
            advisorMenu();
        }

    }

    public void lecturerMenu() {

        System.out.println(systemController.getMenu());
        int selection = scanner.nextInt();

        Lecturer lecturer = (Lecturer) systemController.getLoggedInUser();

        if (selection == 1) {
            Scanner input = new Scanner(System.in);
            System.out.print("Give ShortName: ");
            String shortName = input.nextLine();
            System.out.print("Give FullName: ");
            String fullName = input.nextLine();
            System.out.print("Description: ");
            String description = input.nextLine();
            Course course = new Course(shortName, fullName, description, "");
            lecturer.addCourse(course);
            systemController.getCourses().add(course);
            systemController.save();

        } else if (selection == 2) {
            systemController.setLoggedInUser(null);
        }

        if (systemController.getLoggedInUser() == null) {
            Menu();
        } else {
            lecturerMenu();
        }

    }

}
