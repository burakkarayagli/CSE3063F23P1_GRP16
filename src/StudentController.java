

public class StudentController {


    private Student student;
    // Possible scenarios


    // Sending the chosen courses to advisor. It will add these courses to the lsit temporarily.
    // Depdending on the action of the advisor, course will stay in the list or not.

    // Deleting the wished courses. 

    // Displaying the information of the student. It may be more specific depending on request type

    public StudentController(Student student){
        this.student = student;
    }
    public void sendCourses(Course course){
        student.getCourses().add(course);

        // Student list will be inserted to the json file(to the corresponding course list of the student in json file) for the necessary fields.
    }

    public void deleteCourses(Course course){
        // Similar approach with sendCourses is intended.
    }

}
