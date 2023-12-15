import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

    Student student;

    public StudentController(Student student) {
        this.student = student;
    }

    public StudentController() {
        this.student = new Student();
    }

    public void CourseSelection() {
        showAvailableCourses();

        System.out.println(
                "Enter the numbers of the courses you want to add");

        System.out.println("eg: 1,2,3");
        System.out.println("eg: * for all courses");
        System.out.println("eg: -1 to exit");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayList<Course> courses = student.getAvailableCourses();
        ArrayList<Integer> selectedCourses = parseInput(input, courses);

        for (int i = 0; i < selectedCourses.size(); i++) {
            student.addCourse(courses.get(selectedCourses.get(i)));
        }
    }

    private void showAvailableCourses() {
        ArrayList<Course> courses = student.getAvailableCourses();

        System.out.println("=============Available Courses=============");

        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            System.out.println(i + 1 + "-" + course.getFullName() + " [" + course.getShortName() + "]");
        }

        System.out.println("============================================");
    }

    public void printSelectedCourses() {
        System.out.println("Selected courses of " + student.getPersonName() + " " + student.getPersonSurname());
        System.out.println("====================================");
        for (Course course : student.getSelectedCourses()) {
            System.out.println(course.getFullName() + " (" + course.getShortName() + ")");
        }
        System.out.println("====================================");
    }

    private ArrayList<Integer> parseInput(String input, ArrayList<Course> courses) {

        if (input.equals("*")) {
            ArrayList<Integer> allCourses = new ArrayList<Integer>();
            for (int i = 0; i < courses.size(); i++) {
                allCourses.add(i);
            }
            return allCourses;
        }

        if (input.equals("-1")) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> selectedCourses = new ArrayList<Integer>();
        String[] inputArray = input.split(",");
        for (int i = 0; i < inputArray.length; i++) {
            selectedCourses.add(Integer.parseInt(inputArray[i]));
        }
        return selectedCourses;
    }

}
