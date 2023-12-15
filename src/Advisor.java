
import java.util.ArrayList;
import java.util.List;

public class Advisor extends Staff {

    private List<Student> students;

    public Advisor(String personName, String personSurname, String username, String password,
            String reputation, ArrayList<TimeInterval> officeHours, int salary, String employmentStatus,
            List<Student> students) {
        super(personName, personSurname, username, password, reputation, officeHours, salary,
                employmentStatus);
        this.students = students;
    }

    public Advisor() {
        
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public boolean deleteStudent(Student student) {
        return students.remove(student);
    }

    public ArrayList<Course> getCombinedCourses(Student student) {
        ArrayList<Course> combinedCourses = new ArrayList<Course>();

        for(int i = 0; i < student.getSelectedCourses().size(); i++) {
            combinedCourses.add(student.getSelectedCourses().get(i));
        }
        for(int i = 0; i < student.getAvailableCourses().size(); i++) {
            combinedCourses.add(student.getAvailableCourses().get(i));
        }

        return combinedCourses;
    }

    public boolean approveStudent(Student student, String courseSelections) {
        courseSelections = courseSelections.replaceAll("[.\\s]", "");

        if(courseSelections.equals("*")) {
            for(int i = 0; i < student.getSelectedCourses().size(); i++) {
                student.addCourse(student.getSelectedCourses().get(i));
            }

            return true;
        }

        int selections = 0;

        try {
            selections = Integer.parseInt(courseSelections);
        }
        catch(Exception e) {
            System.out.println("Error: Format is not valid, please enter a valid format.\nEx:\n1,2,3\n1 2 3\n123");
            return false;
        }

        while(selections != 0) {
            int selection = selections % 10;
            
            student.addCourse(student.getSelectedCourses().get(selection-1));
            student.getSelectedCourses().remove(selection-1);
            selections /= 10;

        }

        for(int i = 0; i < student.getSelectedCourses().size(); i++) {
            student.dropCourse(student.getSelectedCourses().get(i));
        }

        return true;
    }

    // public boolean rejectStudent(Student student) {

    // }
    
}
