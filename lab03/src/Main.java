import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("Ten program służy do przechowywania ocen cząstkowych");
        Scanner scan = new Scanner(System.in);
        GradeList listaOcen = new GradeList();
        boolean run = true;
        while (run){
            pokazMenu();
            String choose = scan.nextLine();
            switch (choose) {
                case "a" -> addGradeFunction(listaOcen);
                case "v" -> avgGradeFunction(listaOcen);
                case "x" -> maxGradeFunction(listaOcen);
                case "n" -> minGradeFunction(listaOcen);
                case "e" -> run = false;
            }
        }
    }
    public static void pokazMenu(){
        System.out.println("Jeżeli chcesz dodać nową ocenę, naciści a");
        System.out.println("Jeżeli chcesz wyliczyć średnią, naciśni v");
        System.out.println("Jeżeli chcesz wyświetlić maksymalną ocenę, nasićni x");
        System.out.println("Jeżeli chcesz wyświetlić minimalną ocenę, nasiśni n");
        System.out.println("Jeżeli chcesz wyjść z programu, naciści e");
    }
    public  static  void addGradeFunction(GradeList listaocen){
        System.out.println("Wprowadź ocenę (z przecinkiem):");
        Scanner scan = new Scanner(System.in);
        double grade = scan.nextDouble();
        String res = listaocen.addGrade(grade);
        System.out.println(res);
    }
    public static void avgGradeFunction(GradeList listaocen){
        System.out.println(listaocen.avgGrades() == 0 ? "Brak ocen" : "Średnia ze wszystkich ocen: " + listaocen.avgGrades() );
    }
    public static void maxGradeFunction(GradeList listaocen){
        System.out.println(listaocen.maxGrade() == 0 ? "Brak ocen" : "Maksymalna ocena: " + listaocen.maxGrade() );
    }

    public static void minGradeFunction(GradeList listaocen){
        System.out.println(listaocen.minGrade() == 0 ? "Brak ocen" : "Minimalna ocena: " + listaocen.minGrade() );
    }

}
