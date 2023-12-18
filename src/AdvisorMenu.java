import java.util.ArrayList;
import java.util.Scanner;

public class AdvisorMenu {

    Scanner scanner = new Scanner(System.in);

    SystemController systemController = new SystemController();
    String_Constants StringConstants = new String_Constants();
    Menu menu = new Menu();

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

            ArrayList<Course> coursesOfStudent = advisor.getStudents().get(studentSelection - 1)
                    .getAllCourses();
            for (int i = 0; i < coursesOfStudent.size(); i++) {
                Course course = coursesOfStudent.get(i);
                System.out.println(course.getFullName() + " " + course.getShortName());
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

            advisor.getStudents().get(studentSelection - 1).getTranscript();
        } else if (selection == 3) {
            systemController.setLoggedInUser(null);
        }

        if (systemController.getLoggedInUser() == null) {
            menu.Menu();
        } else {
            advisorMenu();
        }

    }

}
