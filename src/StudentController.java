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

    public void CourseAdding() {
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
            student.addCourse(courses.get(selectedCourses.get(i) - 1));
        }
    }

    public void CourseDropping() {
        showSelectedCourses();

        System.out.println(
                "Enter the numbers of the courses you want to drop");

        System.out.println("eg: 1,2,3");
        System.out.println("eg: * for all courses");
        System.out.println("eg: -1 to exit");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ;

        ArrayList<Course> courses = student.getSelectedCourses();
        ArrayList<Integer> selectedCourses = parseInput(input, courses);

        System.out.println(selectedCourses);
        for (int i = selectedCourses.size() - 1; i >= 0; i--) {
            student.dropCourse(courses.get(selectedCourses.get(i) - 1));
        }
    }

    public void showSelectedCourses() {
        ArrayList<Course> courses = student.getSelectedCourses();

        System.out.println("=============Selected Courses=============");

        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            System.out.println(i + 1 + "-" + course.getFullName() + " [" + course.getShortName() + "]");
        }

        System.out.println("============================================");
    }

    public void showAvailableCourses() {
        ArrayList<Course> courses = student.getAvailableCourses();

        System.out.println("=============Available Courses=============");

        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            System.out.println(i + 1 + "-" + course.getFullName() + " [" + course.getShortName() + "]");
        }

        System.out.println("============================================");
    }

    public void showTranscript() {
        System.out.println("Transcript of " + student.getPersonName() + " " + student.getPersonSurname());
        Transcript transcript = student.getTranscript();
        String grades = transcript.getGrades();

        System.out.println("=================Transcript==================");
        System.out.println(grades);
        System.out.println("=============================================");
    }

    private ArrayList<Integer> parseInput(String input, ArrayList<Course> courses) {

        // If input is * then return all indexes of courses
        // If input is -1 then return empty array
        // If input is 1,2,3 then return 1,2,3
        // If input is 1,2,3,4,5,6,7,8,9,10 then return 1,2,3,4,5,6,7,8,9,10
        // Else return empty array

        ArrayList<Integer> selectedCourses = new ArrayList<Integer>();

        if (input.equals("*")) {
            for (int i = 0; i < courses.size(); i++) {
                selectedCourses.add(i + 1);
            }
            return selectedCourses;
        } else if (input.equals("-1")) {
            return selectedCourses;
        } else {
            String[] inputArray = input.split(",");
            for (int i = 0; i < inputArray.length; i++) {
                try {
                    int index = Integer.parseInt(inputArray[i]);
                    if (index > 0 && index <= courses.size()) {
                        selectedCourses.add(index);
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input");
                }
            }

            return selectedCourses;
        }
    }

}
