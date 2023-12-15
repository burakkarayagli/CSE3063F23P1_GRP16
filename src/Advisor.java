
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

        for (int i = 0; i < student.getSelectedCourses().size(); i++) {
            combinedCourses.add(student.getSelectedCourses().get(i));
        }
        for (int i = 0; i < student.getAvailableCourses().size(); i++) {
            combinedCourses.add(student.getAvailableCourses().get(i));
        }

        return combinedCourses;
    }

        public boolean approveStudent(Student student, String selections) {
            
            try {
                
            if (selections.equals("*")) {
                student.setStatus("Approved");
                return true;
            } else {
                for (int i = 0; i < student.getSelectedCourses().size() - 1; i++) {
                    if (selections.indexOf(String.valueOf(i + 1)) == -1) {
                        student.dropCourse(student.getSelectedCourses().get(i));
                        student.setStatus("Rejected");
                    }
                }
            }
            return true;
            }
            catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }

        }

        // public boolean rejectStudent(Student student) {

        // }

    }
