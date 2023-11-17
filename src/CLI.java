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

        if (systemController.getLoggedInUser() instanceof Student) {
            Student student = (Student) systemController.getLoggedInUser();
            if (selection == 1) {
                System.out.println(student.getApproved());
                System.out.println("AVAILABLE COURSES THAT STUDENT CAN TAKE");

                ArrayList<CourseSection> availableCourses = systemController.getAvailableCourses(student);
                for (int i = 0; i < availableCourses.size(); i++) {
                    CourseSection courseSection = availableCourses.get(i);
                    System.out.println(i + 1 + ". " + courseSection.getFullName() + " " +
                            courseSection.getSectionName()
                            + " " + courseSection.getShortName());
                }

                Scanner input = new Scanner(System.in);
                System.out.println("You are able to choose one of the courses above.");
                System.out.print(
                        "Please enter the number of the course you want to choose(Enter -1 if you want to not choose any course): ");
                int i = input.nextInt();
                if (i == -1)
                    return;
                else {
                    systemController.applyCourse(student, availableCourses.get(i - 1));
                }

            } else if (selection == 2) {

            } else if (selection == 3) {
                student.printTranscriptInfo();
            } else if (selection == 4) {


                systemController.printStudentCourses(student);
                
            }
            else if (selection == 5) {
            }

        } else if (systemController.getLoggedInUser() instanceof Advisor) {
            Advisor advisor = (Advisor) systemController.getLoggedInUser();

            if (selection == 1) {
                System.out.println("Which student do you want to go on?");

                for (int j = 0; j < advisor.getStudents().size(); j++) {
                    System.out.println((j + 1) + "- " + advisor.getStudents().get(j).getFullName());
                }
                int studentSelection = scanner.nextInt();
                System.out.println(
                        "List of courses for student " + advisor.getStudents().get(studentSelection - 1).getFullName());

                // ArrayList<CourseSection> coursesOfStudent = systemController
                // .getUntakenCourses(advisor.getStudents().get(studentSelection - 1));
                // for (int i = 0; i < coursesOfStudent.size(); i++) {
                // CourseSection courseSection = coursesOfStudent.get(i);
                // System.out.println(courseSection.getFullName() + " " +
                // courseSection.getSectionName()
                // + " " + courseSection.getShortName());
                // }

                ArrayList<CourseSection> coursesOfStudent = advisor.getStudents().get(studentSelection - 1)
                        .getCourses();
                for (int i = 0; i < coursesOfStudent.size(); i++) {
                    CourseSection courseSection = coursesOfStudent.get(i);
                    System.out.println(courseSection.getFullName() + " " +
                            courseSection.getSectionName()
                            + " " + courseSection.getShortName());
                }

                System.out.println("1-Approve selections\n2-Reject selections");
                int decision = scanner.nextInt();

                if (decision == 1) {
                    // System.out.println(advisor.getStudents().get(studentSelection -
                    // 1).getApproved());
                    systemController.approveCourse(advisor, studentSelection);
                    // System.out.println(advisor.getStudents().get(studentSelection -
                    // 1).getApproved());
                }
                else if(decision==2){

                    systemController.rejectCourse(advisor, studentSelection);
                }

            } else if (selection == 2) {
                System.out.println("Which student do you want to go on?");

                for (int j = 0; j < advisor.getStudents().size(); j++) {
                    System.out.println((j + 1) + "- " + advisor.getStudents().get(j).getFullName());
                }
                int studentSelection = scanner.nextInt();

                advisor.getStudents().get(studentSelection - 1).printTranscriptInfo();
            }
        } else if (systemController.getLoggedInUser() instanceof Lecturer) {
            Lecturer lecturer = (Lecturer) systemController.getLoggedInUser();
            if (selection == 1) {
                Scanner input = new Scanner(System.in);
                System.out.print("Give ShortName: ");
                String shortName = input.nextLine();
                System.out.print("Give FullName: ");
                String fullName = input.nextLine();
                System.out.print("Description: ");
                String description = input.nextLine();
                Course course = new Course(shortName, fullName, description, "");
                lecturer.addCourse(course);
                systemController.save();
            }
            // } else if (systemController.getLoggedInUser() instanceof Advisor) {
            // Advisor advisor = (Advisor) systemController.getLoggedInUser();

            // ArrayList<Advisor> advisors = new
            // ArrayList<>(systemController.getAdvisorList());

            // if (selection == 1) {
            // System.out.println("Which student do you want to go on?");

            // for (int i = 0; i < advisors.size(); i++) {
            // if (advisor == advisors.get(i)) {

            // for (int j = 0; j < advisor.getStudents().size(); j++) {
            // System.out.println((j + 1) + "- " +
            // advisor.getStudents().get(j).getFullName());
            // }
            // int studentSelection = scanner.nextInt();
            // System.out.println("List of courses for student "
            // + advisor.getStudents().get(studentSelection - 1).getFullName());
            // systemController.printAvailableCourses(advisor.getStudents().get(studentSelection
            // - 1));

            // System.out.println("1-Approve selections\n2-Reject selections");
            // int decision = scanner.nextInt();

            // if (decision == 1) {
            // // System.out.println(advisor.getStudents().get(studentSelection -
            // // 1).getApproved());
            // advisor.getStudents().get(studentSelection - 1).setApproved(true);
            // // System.out.println(advisor.getStudents().get(studentSelection -
            // // 1).getApproved());
            // }
            // break;
            // }

            // }
            // } else if (selection == 2) {
            // System.out.println("Which student do you want to go on?");
            // for (int i = 0; i < advisors.size(); i++) {
            // if (advisor == advisors.get(i)) {

            // for (int j = 0; j < advisor.getStudents().size(); j++) {
            // System.out.println((j + 1) + "- " +
            // advisor.getStudents().get(j).getFullName());
            // }
            // int studentSelection = scanner.nextInt();

            // advisor.getStudents().get(studentSelection - 1).printTranscriptInfo();
            // }
            // }
            // }
            // } else if (systemController.getLoggedInUser() instanceof Lecturer) {
            // Lecturer lecturer = (Lecturer) systemController.getLoggedInUser();

            // if (selection == 1) {
            // System.out.println(lecturer.getCourses().get(0).getCourseInfo());

            // }
        }

    }

}
