package menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import contollers.LecturerController;
import models.*;

public class LecturerMenu {
    LecturerController lecturerController;

    public LecturerMenu(LecturerController lecturerController) {
        this.lecturerController = lecturerController;
    }

    public LecturerMenu() {
        this.lecturerController = new LecturerController();
    }

    public void lecturerMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("1- Show Given Courses");
            System.out.println("2- Show Students that take the given courses");
            System.out.println("3- Create Course");
            System.out.println("4- Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // showGivenCourses();
                    break;
                case 2:
                    // showStudents();
                    break;
                case 3:
                    createCourse();
                    break;
                case 4:
                    menus.Menu.getInstance().setLoggedInUser(null);
                    menus.Menu.getInstance().LoginMenu();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }
    }

    public void createCourse() {
        System.out.println("Enter the course code");
        System.out.println("eg: CSE1001");
        System.out.println("eg: -1 to exit");
        Scanner scanner = new Scanner(System.in);
        String courseCode = scanner.nextLine();
        if (courseCode.equals("-1")) {
            return;
        }

        System.out.println("Enter the course name");
        System.out.println("eg: Introduction to Computer Science");
        String courseName = scanner.nextLine();

        System.out.println("Enter the course description");
        System.out.println("eg: This course is an introduction to computer science");
        String courseDescription = scanner.nextLine();

        System.out.println("Enter the course prequistes");
        System.out.println("eg: CSE101,CSE102");
        ArrayList<String> coursePrerequisites = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(",")));

        System.out.println("Enter the course semester");
        System.out.println("eg: 1");
        int courseSemester = scanner.nextInt();

        System.out.println("Enter the course credit");
        System.out.println("eg: 3");
        int courseCredit = scanner.nextInt();

        System.out.println("Enter the class hours");
        System.out.println("eg: 3");
        int courseClassHours = scanner.nextInt();

        // get the course type
        System.out.println("Enter the course type");
        System.out.println("\t 1. Mandatory");
        System.out.println("\t 2. Technical Elective");
        System.out.println("\t 3. NonTechnical Elective");
        int courseType = scanner.nextInt();

        Course course = new Course(courseCode, courseName, courseDescription, coursePrerequisites, courseSemester,
                courseCredit, courseClassHours);

        System.out.println("Enter the course section name");
        System.out.println("eg: 1.1");
        String sectionName = scanner.nextLine();

        System.out.println("Enter the course quota");
        System.out.println("eg: 30");
        int quota = scanner.nextInt();

        System.out.println("Enter the course location");
        System.out.println("eg: M1Z11");
        String location = scanner.nextLine();

        ArrayList<TimeInterval> dates = new ArrayList<TimeInterval>();
        while (true) {
            System.out.println("Enter the course day");
            System.out.println("eg: Monday, Tuesday, Wednesday, Thursday or Friday(ony one day)");
            System.out.println("eg: -1 to exit");
            String day = scanner.nextLine();
            if (day.equals("-1")) {
                break;
            }
            System.out.println("Enter the course start time");
            System.out.println("eg: 09:30, 10:30, 11:30, 13:00, 14:00, 15:00, 16:00(only one time)");
            String startTime = scanner.nextLine();
            String endTime = "";
            switch (startTime) {
                case "09:30":
                    endTime = "10:20";
                    break;
                case "10:30":
                    endTime = "11:20";
                    break;
                case "11:30":
                    endTime = "12:20";
                    break;
                case "13:00":
                    endTime = "13:50";
                    break;
                case "14:00":
                    endTime = "14:50";
                    break;
                case "15:00":
                    endTime = "15:50";
                    break;
                case "16:00":
                    endTime = "16:50";
                    break;
            }
            if (endTime.equals("")) {
                System.out.println("Invalid time");
                continue;
            }
            dates.add(new TimeInterval(day, startTime, endTime));
        }

        if (courseType == 1) {
            System.out.println("Enter the course lab hours");
            System.out.println("eg: 3");
            System.out.println("eg: 0 if there is no lab hours");
            int labHours = scanner.nextInt();

            MandatoryCourse mandatoryCourse = new MandatoryCourse(course, dates, sectionName, null, quota,
                    location,
                    labHours);
            this.lecturerController.addLecturedCourse(mandatoryCourse);

        } else if (courseType == 2) {
            System.out.println("Enter the course required credit");
            System.out.println("eg: 60");
            int requiredCredit = scanner.nextInt();

            TechnicalElectiveCourse technicalElectiveCourse = new TechnicalElectiveCourse(course, dates, sectionName,
                    null, quota, location, requiredCredit);
            this.lecturerController.addLecturedCourse(technicalElectiveCourse);

        } else if (courseType == 3) {
            System.out.println("Enter the remote or not");
            System.out.println("eg: true or false");
            boolean isRemote = scanner.nextBoolean();

            NonTechnicalElectiveCourse nonTechnicalElectiveCourse = new NonTechnicalElectiveCourse(course, dates,
                    sectionName, null, quota, location, isRemote);
            this.lecturerController.addLecturedCourse(nonTechnicalElectiveCourse);

        } else {
            System.out.println("Invalid course type");
        }

    }

}
