package menus;

import java.util.ArrayList;
import java.util.Scanner;
import models.*;
import constants.String_Constants;
import contollers.AdvisorController;
import menus.*;

public class AdvisorMenu {

    private AdvisorController advisorController;
    Scanner scanner = new Scanner(System.in);

    String_Constants StringConstants = new String_Constants();

    public AdvisorMenu(AdvisorController advisorController){
        this.advisorController = advisorController;
    }
    public void advisorMenu() {


        System.out.println("Which student do you want to go on?");
        Menu menu = new Menu();
        for (int j = 0; j < advisorController.getStudents().size(); j++) {
            System.out.println((j + 1) + "- " + advisorController.getStudents().get(j).getFullName());
        }

        int studentSelection = scanner.nextInt();

        Student student = advisorController.getStudents().get(studentSelection - 1);

        System.out.println("List of courses for student " + advisorController.getStudents().get(studentSelection - 1).getFullName());

        ArrayList<Course> coursesOfStudent = advisorController.getStudents().get(studentSelection - 1).getSelectedCourses();
        for (int i = 0; i < coursesOfStudent.size(); i++) {
            Course course = coursesOfStudent.get(i);
            System.out.println((i + 1) + " -> " + course.getFullName() + " " + course.getShortName());
        }

        System.out.println("Please enter the courses you want to approve for the student \n"
                + "Type * to approve all courses\n"
                + "The non-chosen ones will automatically be rejected\n"
                + "Selection/s: ");
        scanner.nextLine();
        String selections = scanner.nextLine();


        System.out.println("1-Approve selections\n2-Reject selections");
        int decision = 0;
        try{
            decision = scanner.nextInt();
        }
        catch(Exception e){
            System.out.println("Invalid input type. Please try again.");
            
        }
        if(decision!=1 && decision != 2){
            System.out.println("Input must be 1 or 2. Please try again.");
            advisorMenu();
        }

        try{
            if (decision == 1) {
                advisorController.getStudents().get(studentSelection-1).setStatus("Approved");
                advisorController.approveStudentSelection(student, selections);
            } else if (decision == 2) {
                advisorController.rejectStudentSelection(student, selections);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            advisorMenu();
        }
        if (menu.getLoggedInUser() == null) {
            menu.LoginMenu();
        } else {
            advisorMenu();
        }
        
    }
}