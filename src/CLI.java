import java.util.ArrayList;
import java.util.Scanner;

public class CLI {

    
    public static void main(String[] args) {
        // Create a new system controller with null logged in user
        SystemController systemController = new SystemController();
        Scanner scanner = new Scanner(System.in);
        
        String_Constants StringConstants = new String_Constants();
        // While there is no logged in user, ask for username and password
        while (systemController.getLoggedInUser() == null) {
            System.out.println(StringConstants.WELCOME_MESSAGE);
            System.out.println(StringConstants.LOGIN_MESSAGE);
            System.out.print(StringConstants.USERNAME_MESSAGE);
            String username = scanner.nextLine();
            System.out.print(StringConstants.PASSWORD_MESSAGE);
            String password = scanner.nextLine();
            // If the username and password are correct, authenticate the user and set the
            // logged in user
            boolean isLoged = systemController.Authenticate(username, password);
            if (isLoged) {
                System.out.println(StringConstants.LOGIN_SUCCESSFUL_MESSAGE);
            } else {
                System.out.println(StringConstants.LOGIN_UNSUCCESSFUL_MESSAGE);
            }
            System.out.println();
        }

        // Print the menu for the logged in user
        System.out.println(systemController.getMenu());
        // Get the user's selection
        int selection = scanner.nextInt();

        if(systemController.getLoggedInUser() instanceof Student){
            Student student = (Student)systemController.getLoggedInUser();
            if(selection==1){
                System.out.println("AVAILABLE COURSES THAT STUDENT CAN TAKE");
                ArrayList<CourseSection> untakenCourses = new ArrayList<CourseSection>();
                systemController.printAvailableCourses(student, untakenCourses);
                Scanner input = new Scanner(System.in);
                System.out.println("You are able to choose one of the courses above.");
                System.out.print("Please enter the number of the course you want to choose(Enter -1 if you want to not choose any course): ");
                int i = input.nextInt();
                if(i==-1)
                    return;
                if(systemController.checkPrerequisite()){
                    systemController.applyCourse(student, untakenCourses.get(i-1));
                }
                
            }   
            else if(selection==2){

            }
            else if(selection==3){
                student.printTranscriptInfo();
            }
            else if(selection==4){
                System.out.println("Logout successful.");
                return;
            }
        }

    }

    public class StudentCLI {
        // ?
    }

}
