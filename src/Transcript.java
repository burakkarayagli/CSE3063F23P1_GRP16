import java.util.ArrayList;

public class Transcript {
    private ArrayList<Grade> listGrades;

    public Transcript() {
        listGrades = new ArrayList<Grade>();
    }

    public Transcript(ArrayList<Grade> initialGrades) {
        listGrades = new ArrayList<Grade>(initialGrades);
    }

    public String getGrades() {
        StringBuilder result = new StringBuilder();
        for (Grade grade : listGrades) {
            result.append("Course name: ").append(grade.getCourse().getFullName()).append(" | Student Grade: ").append(grade.getGrade()).append("\n");
        }
        return result.toString();
    }
    
    public ArrayList<Grade> getGradeList(){
        return listGrades;
    }

    public boolean addGrade(Grade grade) {
        listGrades.add(grade);
        return (grade == null ? true : false);
    }

    public boolean deleteGrade(Grade grade) {
        for(int i = 0; i < listGrades.size(); i++) {
            if(listGrades.get(i) == grade) {
                listGrades.remove(i);
                return true;
            }
        }
        return false;
    }
}
