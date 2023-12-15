import java.util.ArrayList;
import java.util.Scanner;

public class CLI {

    public static void main(String[] args) {
        Json json = new Json();
        ArrayList<Student> students = json.readStudents();
        Student student = students.get(1);
        StudentController studentController = new StudentController(student);

        String choice = "";

        while (choice != "6") {
            System.out.println("1. Add Course");
            System.out.println("2. Drop Course");
            System.out.println("3. Show selected courses");
            System.out.println("4. Show available courses");
            System.out.println("5. Show transcript");
            System.out.println("6. Exit");

            Scanner scanner = new Scanner(System.in);

            choice = scanner.nextLine();

            if (choice.equals("1")) {
                studentController.CourseAdding();
            } else if (choice.equals("2")) {
                studentController.CourseDropping();
            } else if (choice.equals("3")) {
                studentController.showSelectedCourses();
            } else if (choice.equals("4")) {
                studentController.showAvailableCourses();
            } else if (choice.equals("5")) {
                studentController.showTranscript();
            } else if (choice.equals("6")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }

        studentController.CourseAdding();
        studentController.showSelectedCourses();

        // student.printTranscript();

        // for (int i = 0; i < student.getAllCourses().size(); i++) {
        // System.out.println(student.getAllCourses().get(i).getShortName() + "[" + i +
        // "]");
        // }

        // System.out.println(student.checkStudentPassedCourse(student.getAllCourses().get(5)));
    }

    public static void main2(String[] args) {
        // Create a new system controller with null logged in user
        SystemController systemController = new SystemController();
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        String_Constants StringConstants = new String_Constants();

        menu.Menu();
    }

}
