package menus;

import java.util.ArrayList;
import java.util.Scanner;

import models.*;
import constants.String_Constants;
import contollers.AdvisorController;
import menus.*;

import java.util.Collections;

public class AdvisorMenu {

    private AdvisorController advisorController;
    Scanner scanner = new Scanner(System.in);

    String_Constants StringConstants = new String_Constants();

    public AdvisorMenu(AdvisorController advisorController) {
        this.advisorController = advisorController;
    }

    public void advisorMenu() {
        
        int studentSelection = 0;
        while(studentSelection<1 || studentSelection>advisorController.getStudents().size()){
            System.out.println("Which student do you want to go on?\n"
                + "Type -1 for exit");
            for (int j = 0; j < advisorController.getStudents().size(); j++) {
                System.out.println((j + 1) + "- " + advisorController.getStudents().get(j).getFullName());
            }
            try{
                // scanner = new Scanner(System.in);
                studentSelection = scanner.nextInt();
            }
            catch(Exception e){
                System.out.println("Invalid choice. Please try again.");
                scanner.nextLine();

            }
        }

        if (studentSelection == -1) {
            Menu menu = new Menu();
            menu.LoginMenu();
            return;
        }

        Student student = advisorController.getStudents().get(studentSelection - 1);

        System.out.println("List of courses for student "
                + advisorController.getStudents().get(studentSelection - 1).getFullName());

        ArrayList<Course> coursesOfStudent = advisorController.getStudents().get(studentSelection - 1)
                .getSelectedCourses();
        if ((student.getStatus() == "Rejected" || student.getStatus() == "Approved")) {
            System.out.println("Approve/Reject process is already done for this student.\n");

        } else {
            for (int i = 0; i < coursesOfStudent.size(); i++) {
                Course course = coursesOfStudent.get(i);
                System.out.println((i + 1) + " -> " + course.getFullName() + " " + course.getShortName());
            }
            System.out.println("Please enter the courses you want to approve for the student \n"
                    + "Type * to approve all courses\n"
                    + "The non-chosen ones will automatically be rejected\n"
                    + "Selection/s: ");

            scanner = new Scanner(System.in);
            // scanner.nextLine();
            String selections = scanner.nextLine();

            ArrayList<Integer> sortedSelections = new ArrayList<>();

            while (true) {
                if (selections.equals("*")) {
                    sortedSelections.add(0);
                    advisorController.approveStudentSelection(student, sortedSelections);
                    break;
                } else {

                    if (!isValidFormat(selections)) {
                        System.out.println("Invalid format. Please enter a valid comma-separated list of numbers.\n");
                    } else {
                        sortedSelections = sortNumbers(selections);

                        if (sortedSelections.get(0) <= 0) {
                            // || sortedSelections.get(sortedSelections.size() - 1) >
                            // student.getSelectedCourses().size()
                            System.out.println("Invalid input. Please stay in bounds.\n");
                        } else {
                            advisorController.approveStudentSelection(student, sortedSelections);
                            break;
                        }
                    }
                    System.out.print("Enter a comma-separated list of numbers: ");
                    selections = scanner.nextLine();
                }
            }

        }

        advisorMenu();

    }

    private boolean isValidFormat(String selections) {
        selections = selections.replaceAll("[,\\s]", "");

        try {
            int intValue = Integer.parseInt(selections);
            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + "\n");
            return false;
        }
    }

    private ArrayList<Integer> sortNumbers(String input) {
        // Split the input string by commas, convert the substrings to integers, and
        // sort
        String[] numberStrings = input.split(",");
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString));
        }

        // Sort the ArrayList
        Collections.sort(numbers);

        return numbers;
    }

    // private boolean ifSelectionOutOfBounds(ArrayList<Integer> selections, Student
    // student) {
    // if (selections.get(0) <= 0 || selections.get(selections.size() - 1) >
    // student.getSelectedCourses().size()) {
    // return true;
    // }
    // return false;
    // }
}