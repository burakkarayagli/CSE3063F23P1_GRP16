import java.util.Scanner;
import java.util.ArrayList;

public class LecturerMenu {

    Scanner scanner = new Scanner(System.in);

    String_Constants StringConstants = new String_Constants();
    Menu menu = new Menu();

    public void lecturerMenu() {

        System.out.println(menu.getMenu());
        int selection = scanner.nextInt();

        Lecturer lecturer = (Lecturer) menu.getLoggedInUser();

        if (selection == 1) {
            // ShortName
            System.out.print("Give ShortName: ");
            String shortName = scanner.nextLine();
            // FullName
            System.out.print("Give FullName: ");
            String fullName = scanner.nextLine();
            // Description
            System.out.print("Description: ");
            String description = scanner.nextLine();
            // Prerequisite/s
            System.out.println("How many preqisite does this course have? \nIf there is no prerequisite enter 0");
            int numberOfPrerequisite = scanner.nextInt();

            ArrayList<String> prequisites = new ArrayList<String>();

            if (numberOfPrerequisite != 0) {
                for (int i = 0; i < numberOfPrerequisite; i++) {
                    System.out.println(i + " -> ");
                    String prequisite = scanner.nextLine();
                    prequisites.add(prequisite);
                }
            }
            // Semester
            System.out.println("Give semester: ");
            int semester = scanner.nextInt();
            // Credit
            System.out.println("Give credit:");
            int credit = scanner.nextInt();
            // ClassHours
            System.out.println("classHours");
            int classHours = scanner.nextInt();

            Course course = new Course(shortName, fullName, description, prequisites, semester, credit, classHours);
            lecturer.addlecturedCourses(course);
            lecturer.getLecturedCourses().add(course);
            // systemController.save();

        } else if (selection == 2) {
            menu.setLoggedInUser(null);
        }

        if (menu.getLoggedInUser() == null) {
            menu.Menu();
        } else {
            lecturerMenu();
        }

    }

}
