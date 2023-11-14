import java.util.List;

public class AdvisorController {


    private Advisor advisor;
    
    // Possible scenarios

    public AdvisorController(Advisor advisor){
        this.advisor = advisor;
    }
    public void checkStudents(){
        
        List<Student> students = advisor.getStudents();
        for(int i = 0;i<students.size();i++){

        }
    }
    // Accepting or rejecting the course application.

    // Displaying the information of the advisor. It may be more specific depending on request type

}
