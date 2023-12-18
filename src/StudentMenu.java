import java.util.ArrayList;
import java.util.Scanner;

public class StudentMenu {

    Scanner scanner = new Scanner(System.in);

    SystemController systemController = new SystemController();
    String_Constants StringConstants = new String_Constants();
    Menu menu = new Menu();

    public void studentMenu() {
        System.out.println(systemController.getMenu());
        int selection = scanner.nextInt();

        Student student = (Student) systemController.getLoggedInUser();
        if (selection == 1) {
            System.out.println("AVAILABLE COURSES THAT STUDENT CAN TAKE");
            ArrayList<Course> availableCourses = systemController.getAvailableCourses(student);
            for (int i = 0; i < availableCourses.size(); i++) {
                Course courseSection = availableCourses.get(i);
                System.out.println(i + 1 + ". " + courseSection.getFullName() + " " + courseSection.getShortName());
            }

            System.out.println("You are able to choose one of the courses above.");
            System.out.print(
                    "Please select the course you want to take(Enter -1 if you don't want to choose any course): ");

            int i = scanner.nextInt();
            if (i == -1)
                studentMenu();
            else {
                try {
                    student.addCourse(availableCourses.get(i - 1));
                } catch (Exception e) {
                    System.out.println(StringConstants.INVALID_OPTION_MESSAGE);
                }
            }

        } else if (selection == 2) {
            student.getTranscript();
        } else if (selection == 3) {
            systemController.setLoggedInUser(null);
        }

        else if (selection == 4) {
            ArrayList<Course> coursesTaken = student.getSelectedCourses();

            for (int i = 0; i < coursesTaken.size(); i++) {
                System.out.println(coursesTaken.get(i).getShortName() + " " + coursesTaken.get(i).getFullName() + " "
                        + coursesTaken.get(i).getShortName());
            }
        }

        if (systemController.getLoggedInUser() == null) {
            menu.Menu();
        } else {
            studentMenu();
        }

    }

}
