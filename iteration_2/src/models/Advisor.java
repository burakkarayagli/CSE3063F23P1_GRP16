package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

import utils.DataUtils;

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

    // It provides adding or dropping the course of the student by the advisor.
    public void studentCourseOrganization() {
        Scanner input = new Scanner(System.in);
        int num = 0;
        for (int i = 0; i < students.size(); i++) {
            System.out.println("Eligible Students");
            System.out.println("Please select one of them");
            System.out.println((i + 1) + " " + students.get(i).getFullName());

        }
        num = input.nextInt();
        Student student = students.get(num - 1);
        ArrayList<Course> combinedCourseList = getCombinedCourses(student);
        for (int i = 0; i < combinedCourseList.size(); i++) {
            System.out.println((i + 1) + " " + combinedCourseList.get(i).getFullName());
        }
        int selection = input.nextInt();
        Course chosenCourse = combinedCourseList.get(selection - 1);
        if (student.getSelectedCourses().contains(chosenCourse)) {
            System.out.println("Course chosen by the student has been dropped.");
            student.dropCourse(chosenCourse);
        } else {
            System.out.println("Course has been added to the list of the student.");
            student.addCourse(chosenCourse);
        }
        input.close();
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

    public boolean rejectStudent(Student student, String selections) throws Exception {
        try {

            if (selections.equals("*")) {
                student.setStatus("Rejected");
                student.getSelectedCourses().clear();
                return true;
            } else {
                ArrayList<Course> rejectedCourses = new ArrayList<>();
                String[] input = selections.split(",");

                for (int j = 0; j < input.length; j++) {
                    int selection = Integer.parseInt(input[j]);
                    rejectedCourses.add(student.getSelectedCourses().get(selection - 1));
                }
                for (int i = 0; i < rejectedCourses.size(); i++) {
                    student.dropCourse(rejectedCourses.get(i));
                }
            }

            student.setStatus("Rejected");
            // save the advisors
            DataUtils dataUtils = DataUtils.getInstance();
            ArrayList<Advisor> advisors = dataUtils.getAdvisors();
            for (int i = 0; i < advisors.size(); i++) {
                if (advisors.get(i).getUsername().equals(this.getUsername())) {
                    advisors.set(i, this);
                }
            }
            dataUtils.writeAdvisors(advisors);
            ArrayList<Student> students = dataUtils.getStudents();
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getUsername().equals(student.getUsername())) {
                    students.set(i, student);
                }
            }
            dataUtils.writeStudents(students);

            return true;
        } catch (Exception e) {
            throw new Exception("Input must only include numbers. Please try again.");
        }
    }

    public boolean approveStudent(Student student, ArrayList<Integer> selections) {

        try {

            if (selections.get(0) == 0 && selections.size() == 1) {
                student.setStatus("Approved");
                // save the advisors
                DataUtils dataUtils = DataUtils.getInstance();
                ArrayList<Advisor> advisors = dataUtils.getAdvisors();
                for (int i = 0; i < advisors.size(); i++) {
                    if (advisors.get(i).getUsername().equals(this.getUsername())) {
                        advisors.set(i, this);
                    }
                }
                dataUtils.writeAdvisors(advisors);
                ArrayList<Student> students = dataUtils.getStudents();
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getUsername().equals(student.getUsername())) {
                        students.set(i, student);
                    }
                }
                dataUtils.writeStudents(students);
                return true;
            } else {
                boolean status = false;

                boolean exists = false;
                for (int i = student.getSelectedCourses().size(); i > 0; i--) {
                    // System.out.println(" --> " + i + " - " + "j-> " + selections.get(j) + "
                    // course -> " + student.getSelectedCourses().get(i-1) );
                    exists = false;
                    for (int j = selections.size(); j > 0; j--) {
                        if (selections.get(j - 1) == i) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        student.dropCourse(student.getSelectedCourses().get(i - 1));
                        status = true;
                    }
                }
                student.setStatus(status ? "Rejected" : "Approved");
            }

            // save the advisors
            DataUtils dataUtils = DataUtils.getInstance();
            ArrayList<Advisor> advisors = dataUtils.getAdvisors();
            for (int i = 0; i < advisors.size(); i++) {
                if (advisors.get(i).getUsername().equals(this.getUsername())) {
                    advisors.set(i, this);
                }
            }
            dataUtils.writeAdvisors(advisors);
            ArrayList<Student> students = dataUtils.getStudents();
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getUsername().equals(student.getUsername())) {
                    students.set(i, student);
                }
            }
            dataUtils.writeStudents(students);

            System.out.println("LDSHGLDSJKGJDSL.");

            return true;
        } catch (Exception e) {
            System.out.println("Error in Advisor.java approveStudent: " + e.getMessage());
            return false;
        }

    }


    // Alternative approveStudent method
    /*
     * public boolean approveStudent(Student student){
     * ArrayList<Course> selectedCourses = student.getSelectedCourses();
     * Scanner input = new Scanner(System.in);
     * int operation = 0;
     * while (operation != 1 || operation != 2) {
     * System.out.println("Please select the approval type:");
     * System.out.println("1. Approve whole");
     * System.out.println("2. Approve one by one");
     * System.out.println("3. Skip");
     * operation = input.nextInt();
     * if(operation != 1 || operation != 2){
     * System.out.println("Please select one of the operations showcased.\n");
     * }
     * else if(operation==1){
     * if(student.getTotalCredit()>40){
     * student.getWarnings(1); // It requests the first warning shooting out.
     * }
     * else{
     * student.setStatus("Approved");
     * }
     * }
     * else if(operation==2){
     * int i = 0;
     * int approvalStatus = 0;
     * while(i<student.getSelectedCourses().size()){
     * System.out.println("Do you approve the course "+student.getSelectedCourses().
     * get(i).getFullName()+"?(1: approve, 0: reject, -1: skip)");
     * approvalStatus = input.nextInt();
     * if(approvalStatus==1){
     * i++;
     * }
     * else if(approvalStatus==0){
     * Course targetCourse = student.getAvailableCourses().get(i);
     * student.getSelectedCourses().remove(targetCourse);
     * }
     * else if(approvalStatus!=-1)
     * System.out.println("Please type one of the options showcased.\n");
     * }
     * student.setStatus("Approved");
     * }
     * else if(operation==3){
     * student.setStatus("Pending");
     * return false;
     * }
     * }
     */

    // public boolean rejectStudent(Student student) {

    // }

}
