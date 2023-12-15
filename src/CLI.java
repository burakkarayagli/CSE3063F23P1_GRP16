import java.util.ArrayList;
import java.util.Scanner;

public class CLI {

    public static void main(String[] args) {
        Json json = new Json();
        ArrayList<Student> students = json.readStudents();
        Student student = students.get(1);
        StudentController studentController = new StudentController(student);
        studentController.CourseSelection();
        studentController.printSelectedCourses();

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
