package models;

import java.util.ArrayList;

public class Transcript {
    private ArrayList<Grade> listGrades;
    private String notes;

    public Transcript() {
        this.listGrades = new ArrayList<Grade>();
        this.notes = "";
    }

    public Transcript(ArrayList<Grade> initialGrades) {
        this.listGrades = new ArrayList<Grade>(initialGrades);
    }

    public Transcript(ArrayList<Grade> initialGrades, String notes) {
        this.listGrades = new ArrayList<Grade>(initialGrades);
        this.notes = notes;
    }

    public String getGrades() {
        StringBuilder result = new StringBuilder();
        for (Grade grade : listGrades) {
            result.append("Course name: ").append(grade.getCourse().getFullName()).append(" | Student Grade: ")
                    .append(grade.getGrade()).append("\n");
        }
        return result.toString();
    }

    public ArrayList<Grade> getGradeList() {
        return listGrades;
    }

    public boolean addGrade(Grade grade) {
        listGrades.add(grade);
        return (grade == null ? true : false);
    }

    public boolean deleteGrade(Grade grade) {
        for (int i = 0; i < listGrades.size(); i++) {
            if (listGrades.get(i) == grade) {
                listGrades.remove(i);
                return true;
            }
        }
        return false;
    }

    public double calculateCumulativeGPA() {
        double sum = 0;
        int count = 0;
        int totalCredit = 0;
        int credit = 0;
        for (int i = 0; i < listGrades.size(); i++) {
            credit = listGrades.get(i).getCourse().getCredit();
            sum += Double.parseDouble(listGrades.get(i).getGrade()) * credit;
            count++;
            totalCredit += credit;
        }
        if (count == 0 || totalCredit == 0)
            return 0.0;
        return sum / (count * totalCredit);
    }

    public double calculateSemesterGPA(int semester) {
        double sum = 0;
        int count = 0;
        int totalCredit = 0;
        int credit = 0;
        for (int i = 0; i < listGrades.size(); i++) {
            if (listGrades.get(i).getCourse().getSemester() == semester) {
                credit = listGrades.get(i).getCourse().getCredit();
                sum += Double.parseDouble(listGrades.get(i).getGrade()) * credit;
                count++;
                totalCredit += credit;
            }
        }
        if (count == 0 || totalCredit == 0)
            return 0.0;
        return sum / (count * totalCredit);
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Transcript: \n");
        result.append("Grades: \n");
        for (Grade grade : listGrades) {
            result.append("Course name: ").append(grade.getCourse().getFullName()).append(" | Student Grade: ")
                    .append(grade.getGrade()).append("\n");
        }
        result.append("Notes: ").append(notes).append("\n");
        return result.toString();
    }
}
