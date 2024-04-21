import java.util.ArrayList;
public class GradeList {
    private final ArrayList<Double> grades;

    public GradeList(){
      this.grades = new ArrayList<>();
    }
    public boolean isValid(double grade){
        return  grade == 2.0 || grade == 3.0 || grade == 3.5 || grade == 4.0 || grade == 4.5 || grade == 5.0;

    }
    public String addGrade(double grade){
       if (isValid(grade)){
           grades.add(grade);
           return  "Wartość dodana";
       } else {
           return "Nie poprawna wartość, nie jest dodana";

       }
    }

    public Double avgGrades(){
        if (grades.size() > 0) {
            double sum = 0;
            for (double i : grades) {
                sum += i;
            }
            return sum/grades.size();
        } else {
            return  0.0;
        }
    }

    public Double maxGrade(){
        if (grades.size() > 0) {
            double max = grades.get(0);
            for (double i : grades) {
                if (max < i){
                    max = i;
                }
            }
            return  max;
        } else {
            return  0.0;
        }
    }

    public Double minGrade(){
        if (grades.size() > 0) {
            double min = grades.get(0);
            for (double i : grades) {
                if (min > i){
                    min = i;
                }
            }
            return  min;
        } else {
            return  0.0;
        }
    }

}


