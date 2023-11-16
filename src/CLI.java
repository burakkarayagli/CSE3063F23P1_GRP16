import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        //Create a new system controller with null logged in user
        SystemController systemController = new SystemController();
        Scanner scanner = new Scanner(System.in);;

        //While there is no logged in user, ask for username and password
        while (systemController.getLoggedInUser() == null) {
            System.out.println(String_Constants.WELCOME_MESSAGE);
            System.out.println(String_Constants.LOGIN_MESSAGE);
            System.out.println(String_Constants.USERNAME_MESSAGE);
            String username = scanner.nextLine();
            System.out.println(String_Constants.PASSWORD_MESSAGE);
            String password = scanner.nextLine();
            //If the username and password are correct, authenticate the user and set the logged in user
            systemController.Authenticate(username, password);
        }

        System.out.println(String_Constants.LOGIN_SUCCESSFUL_MESSAGE);

        //Print the menu for the logged in user
        System.out.println(systemController.getMenu());
        //Get the user's selection
        int selection = scanner.nextInt();

    }

    public class StudentCLI {
        //?
    }

    


}
