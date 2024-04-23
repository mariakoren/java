import java.time.LocalTime;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {



        System.out.println("Ten program służy do obsługi tygodniowych spotkań");
        Scanner scan = new Scanner(System.in);
        Calendar calendar = new Calendar();
        boolean run = true;
        while (run){
            printMenu();
            String choose = scan.nextLine();
            switch (choose) {
                case "a" -> addMeeting(calendar);
                case "d" -> deleteMeeting(calendar);
                case "p" -> printMeetings(calendar);
                case "pd" -> printForDay(calendar);
                case "pp" -> printForPriority(calendar);
                case "ps" -> printStartFrom(calendar);
                case "q" -> addSeven(calendar);
                case "e" -> run = false;
            }
        }
    }

    public static void printMenu(){
        System.out.println("Jeżeli chcesz dodać spotkanie, naciści a");
        System.out.println("Jeżeli chcesz usunąć spotkanie, naciśni d");
        System.out.println("Jeżeli chcesz wyświetlić spotkania, nasićni p");
        System.out.println("Jeżeli chcesz wyświetlić spotkania po dniam, nasićni pd");
        System.out.println("Jeżeli chcesz dodać 7 spotkań, naciśni q");
        System.out.println("Jeżeli chcesz wyświetlić po podanym priorytecie, naciśni pp");
        System.out.println("Jeżeli chcesz wyjść z programu, naciśni e");

    }

    public static void addMeeting(Calendar calendar){
//        calendar.displayAllMeetings();
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj dzień dla którego chcesz dodać spotkanie: ");
        String day = scan.nextLine();
        System.out.println("podaj opis: ");
        String desc = scan.nextLine();
        System.out.println("podaj godzinę rozpoczęcia: " );
        String start = scan.nextLine();
        LocalTime timeStart = LocalTime.parse(start);

        System.out.println("podaj godzinę zakończenia: " );
        String end = scan.nextLine();
        LocalTime timeEnd = LocalTime.parse(end);

        System.out.println("podaj priorytet: ");
        double priority = scan.nextInt();
        Meeting meeting = new Meeting(desc, timeStart, timeEnd,0, priority);
        calendar.addMeeting(day, meeting);
    }

    public static void  deleteMeeting(Calendar calendar) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj dzień dla którego chcesz usunąć spotkanie: ");
        String day = scan.nextLine();
        calendar.displayMeeting(day);
        System.out.println("Podaj id do usunięcia: ");
        double id = scan.nextDouble();
        calendar.deleteMeeting(day, id);

    }

    public static  void printForDay(Calendar calendar){
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj dzień dla którego chcesz wyświetlić spotkanie: ");
        String day = scan.nextLine();
        calendar.displayMeeting(day);
    }

    public static void printMeetings(Calendar calendar){
        calendar.displayAllMeetings();
    }

    public static  void addSeven(Calendar calendar){
        calendar.additionalMethod();
    }

    public static void printForPriority(Calendar calendar){
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj dzień dla którego chcesz wyświetlić spotkanie: ");
        String day = scan.nextLine();
        System.out.println("Podaj priorytet: ");
        double priorytet = scan.nextDouble();
        calendar.displayPriority(day, priorytet);
    }

    public static void printStartFrom(Calendar calendar){
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj dzień dla którego chcesz wyświetlić spotkanie: ");
        String day = scan.nextLine();
        System.out.println("Podaj godzine od której: ");
        String start = scan.nextLine();
        LocalTime timeStart = LocalTime.parse(start);
        calendar.displayStartFrom(day, timeStart);
    }
}