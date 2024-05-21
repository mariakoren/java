import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program służy do obsługi tygodniowych spotkań");
        var scanner = new Scanner(System.in);
        var kalendarz = new Kalendarz();
        var running = true;
        while (running) {
            printMenu();
            switch (scanner.nextInt()) {
                case 0 -> przyklad(kalendarz);
                case 1 -> dostanDzien(scanner, (day) -> dodajSpotkanie(scanner, kalendarz, day));
                case 2 -> dostanDzien(scanner, (day) -> dodajZadanie(scanner, kalendarz, day) );
                case 3 -> dostanDzien(scanner, (day) -> usunSpotkanie(scanner, kalendarz, day));
                case 4 -> dostanDzien(scanner, (day) -> usunZadanie(scanner, kalendarz, day));
                case 5 -> dostanDzien(scanner, (day) -> wyswietlSpotkania(kalendarz, day));
                case 6 -> dostanDzien(scanner, (day) -> wyswietlZadania(kalendarz, day));
                case 7 -> dostanDzien(scanner, (day) -> wyswietlSpotkaniaOPriorytecie(scanner, kalendarz, day));
                case 8 -> dostanDzien(scanner, (day) -> wyswietlZadaniaOStatusie(scanner, kalendarz, day));
                case 9 -> dostanDzien(scanner, (day) -> wyswietlSpotkaniaOPriorytecieICzasie(scanner, kalendarz, day));
                case 10 -> dostanDzien(scanner, (day) -> wyswietlZadaniaOStatusieICzasie(scanner, kalendarz, day));
                case 11 -> wszystkieSpotkania(kalendarz);
                case 12 -> wszystkieZadania(kalendarz);
                case 13 -> wszystkie(kalendarz);
                case 14 -> running = false;
                default -> System.out.println("Niepoprawny wybór");
            }
        }
    }

    public static void printMenu(){
        System.out.println();
        System.out.println("0. Dodaj przykładowe spotkania oraz zadania");
        System.out.println("1. Dodaj nowe spotkanie");
        System.out.println("2. Dodaj nowe zadanie");
        System.out.println("3. Usuń spotkanie");
        System.out.println("4. Usuń zadanie");
        System.out.println("5. Wyświetl spotkania w wybranym dniu");
        System.out.println("6. Wyświetl zadania w wybranym dniu");
        System.out.println("7. Wyświetl spotkania o priorytecie w wybranym dniu");
        System.out.println("8. Wyświetl zadania o statusie w wybranym dniu");
        System.out.println("9. Wyświetl spotkania zaczynające się nie wcześniej niż od podanego czasu i o podanym priorytecie w wybranym dniu");
        System.out.println("10. Wyświetl zadania kończących się nie później niż podany czas i o podanym statusie");
        System.out.println("11. Pokaż wszystkie spotkania");
        System.out.println("12. Pokaż wszystkie zadania");
        System.out.println("13. Pokaż wszystkie zdarzenia");
        System.out.println("14. Wyjście");
    }

    private static void przyklad(Kalendarz kalendarz) {
        var spotkanie1 = new Spotkanie("opis spotkania 1", LocalTime.of(8, 0), LocalTime.of(9, 0), Priorytet.NORMALNE);
        var spotkanie2 = new Spotkanie("opis spotkania 2", LocalTime.of(9, 0), LocalTime.of(10, 0), Priorytet.WYSOKIE);
        var spotkanie3 = new Spotkanie("opis spotkania 3", LocalTime.of(10, 0), LocalTime.of(11, 0), Priorytet.NAJWYŻSZE);
        var spotkanie4 = new Spotkanie("opis spotkania 4", LocalTime.of(11, 0), LocalTime.of(12, 0), Priorytet.NORMALNE);
        var spotkanie5 = new Spotkanie("opis spotkania 5", LocalTime.of(12, 0), LocalTime.of(13, 0), Priorytet.WYSOKIE);
        var spotkanie6 = new Spotkanie("opis spotkania 6", LocalTime.of(13, 0), LocalTime.of(16, 0), Priorytet.NAJWYŻSZE);
        var spotkanie7 = new Spotkanie("opis spotkania 7", LocalTime.of(14, 0), LocalTime.of(15, 0), Priorytet.NORMALNE);
        var zadanie1 = new Zadanie("opis zadania 1", LocalTime.of(8, 0), LocalTime.of(9, 0), Status.PLANOWANE);
        var zadanie2 = new Zadanie("opis zadania 2", LocalTime.of(9, 0), LocalTime.of(10, 0), Status.POTWIERDZONE);
        var zadanie3 = new Zadanie("opis zadania 3", LocalTime.of(10, 0), LocalTime.of(11, 0), Status.REALIZOWANE);
        var zadanie4 = new Zadanie("opis zadania 4", LocalTime.of(11, 0), LocalTime.of(12, 0), Status.PLANOWANE);
        var zadanie5 = new Zadanie("opis zadania 5", LocalTime.of(12, 0), LocalTime.of(13, 0),Status.POTWIERDZONE);
        var zadanie6 = new Zadanie("opis zadania 6", LocalTime.of(13, 0), LocalTime.of(16, 0), Status.PLANOWANE);
        var zadanie7 = new Zadanie("opis zadania 7", LocalTime.of(14, 0), LocalTime.of(15, 0), Status.WYKONANE);

        try {
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, spotkanie1);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, spotkanie2);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, spotkanie3);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, spotkanie4);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, spotkanie5);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, spotkanie6);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, spotkanie7);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, zadanie1);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, zadanie2);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, zadanie3);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, zadanie4);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, zadanie5);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, zadanie6);
            kalendarz.addZdarzenie(DayOfWeek.MONDAY, zadanie7);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void wszystkie(Kalendarz kalendarz) {
        var spotkania = kalendarz.getDane();
        if (spotkania != null) {
            for (var dzien : spotkania.keySet()) {
                System.out.println(dzien + ":");
                wyswietlSpotkania(kalendarz, dzien);
                wyswietlZadania(kalendarz, dzien);
            }
        } else {
            System.out.println("Brak spotkan");
        }
    }
    private static void wszystkieSpotkania(Kalendarz kalendarz) {
        var spotkania = kalendarz.getDane();
        if (spotkania != null) {
            for (var dzien : spotkania.keySet()) {
                System.out.println(dzien + ":");
                wyswietlSpotkania(kalendarz, dzien);
            }
        } else {
            System.out.println("Brak spotkan");
        }
    }

    private static void wszystkieZadania(Kalendarz kalendarz) {
        var spotkania = kalendarz.getDane();
        if (spotkania != null) {
            for (var dzien : spotkania.keySet()) {
                System.out.println(dzien + ":");
                wyswietlZadania(kalendarz, dzien);
            }
        } else {
            System.out.println("Brak spotkan");
        }
    }

    private static Priorytet dostanPriorytet(Scanner scanner) {
        System.out.println("Podaj priorytet spotkania [1/2/3]");
        return switch (scanner.nextInt()) {
            case 1 -> Priorytet.NORMALNE;
            case 2 -> Priorytet.WYSOKIE;
            case 3 -> Priorytet.NAJWYŻSZE;
            default -> Priorytet.BRAK;
        };
    }

    private static Status dostanStatus(Scanner scanner) {
        System.out.println("Podaj status zadania [1/2/3/4]");
        return switch (scanner.nextInt()) {
            case 1 -> Status.PLANOWANE;
            case 2 -> Status.POTWIERDZONE;
            case 3 -> Status.REALIZOWANE;
            case 4 -> Status.WYKONANE;
            default -> Status.BRAK;
        };
    }

    private static LocalTime dostanCzas(String czas) {
        var split = czas.split(":");
        return LocalTime.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    private static void dostanDzien(Scanner scanner, Consumer<DayOfWeek> fn) {
        System.out.println("Podaj dzień tygodnia [1/2/3/4/5]");
        var dzien = DayOfWeek.of(scanner.nextInt());
        scanner.nextLine();

        switch (dzien) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> fn.accept(dzien);
            default -> System.out.println("Niepoprawny dzień tygodnia");
        }
    }

    private static void dodajSpotkanie(Scanner scanner, Kalendarz kalendarz, DayOfWeek day) {
        System.out.println("Dodawanie nowego spotkania");
        System.out.println("Podaj godzinę rozpoczęcia spotkania [HH:MM]");
        var czasRozpoczecia = dostanCzas(scanner.nextLine());

        System.out.println("Podaj godzinę zakończenia spotkania [HH:MM]");
        var czasZakonczenia = dostanCzas(scanner.nextLine());

        Priorytet priorytet = dostanPriorytet(scanner);
        scanner.nextLine();

        System.out.println("Podaj opis spotkania");
        var opis = scanner.nextLine();

        var spotkanie = new Spotkanie(opis, czasRozpoczecia, czasZakonczenia, priorytet);
        try {
            kalendarz.addZdarzenie(day, spotkanie);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private static void dodajZadanie(Scanner scanner, Kalendarz kalendarz, DayOfWeek day) {
        System.out.println("Dodawanie nowego zadania");
        System.out.println("Podaj godzinę rozpoczęcia zadania [HH:MM]");
        var czasRozpoczecia = dostanCzas(scanner.nextLine());

        System.out.println("Podaj godzinę zakończenia zadania [HH:MM]");
        var czasZakonczenia = dostanCzas(scanner.nextLine());

        Status status = dostanStatus(scanner);
        scanner.nextLine();

        System.out.println("Podaj opis zadania");
        var opis = scanner.nextLine();

        var zadanie = new Zadanie(opis, czasRozpoczecia, czasZakonczenia, status);
        try {
            kalendarz.addZdarzenie(day, zadanie);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void usunSpotkanie(Scanner scanner, Kalendarz kalendarz, DayOfWeek dzien) {
        System.out.println("Podaj godzinę rozpoczęcia spotkania [HH:MM]");
        var czasRozpoczecia = dostanCzas(scanner.nextLine());
        System.out.println("Podaj godzinę zakończenia spotkania [HH:MM]");
        var czasZakonczenia = dostanCzas(scanner.nextLine());
        var spotkania = kalendarz.getZdarzenia((s) -> s instanceof Spotkanie &&  s.getCzasStart().equals(czasRozpoczecia) && s.getCzasKoniec().equals(czasZakonczenia), dzien);
        if (spotkania.size() == 1) {
            kalendarz.getDane().get(dzien).remove(spotkania.get(0));
        } else {
            System.out.println("znaleziono więcej niż jedno spotkanie!");
            System.out.println("usunąć je wszystkie? [y/N]");
            var usr = scanner.next().toLowerCase();
            if (usr.equals("y")) {
                spotkania.forEach((x) -> {
                    kalendarz.getDane().get(dzien).remove(x);
                });
            } else {
                System.out.println("nie usuwam");
            }
        }
    }

    private static void usunZadanie(Scanner scanner, Kalendarz kalendarz, DayOfWeek dzien) {
        System.out.println("Podaj godzinę rozpoczęcia zadania [HH:MM]");
        var czasRozpoczecia = dostanCzas(scanner.nextLine());
        System.out.println("Podaj godzinę zakończenia zadania [HH:MM]");
        var czasZakonczenia = dostanCzas(scanner.nextLine());
        var zadania = kalendarz.getZdarzenia((s) -> s instanceof Zadanie &&  s.getCzasStart().equals(czasRozpoczecia) && s.getCzasKoniec().equals(czasZakonczenia), dzien);
        if (zadania.size() == 1) {
            kalendarz.getDane().get(dzien).remove(zadania.get(0));
        } else {
            System.out.println("znaleziono więcej niż jedno spotkanie!");
            System.out.println("usunąć je wszystkie? [y/N]");
            var usr = scanner.next().toLowerCase();
            if (usr.equals("y")) {
                zadania.forEach((x) -> {
                    kalendarz.getDane().get(dzien).remove(x);
                });
            } else {
                System.out.println("nie usuwam");
            }
        }
    }

    private static void wyswietlSpotkania(Kalendarz kalendarz, DayOfWeek day) {
        var help = kalendarz.getDane();
        if (help != null){
            var zdarzenia = kalendarz.getDane().get(day);
            if (zdarzenia == null) {
                System.out.println("Brak zdarzeń w wybranym dniu");
            } else {
                var spotkania = kalendarz.getZdarzenia(s -> s instanceof Spotkanie, day );
                for (var spotkanie : spotkania) {
                    System.out.println(spotkanie);
                }
                System.out.println();
            }
        } else {
            System.out.println("Brak spotkań");
        }
    }

    private static void wyswietlZadania(Kalendarz kalendarz, DayOfWeek day) {
        var help = kalendarz.getDane();
        if (help != null){
            var zdarzenia = kalendarz.getDane().get(day);
            if (zdarzenia == null) {
                System.out.println("Brak zdarzeń w wybranym dniu");
            } else {
                var zadania = kalendarz.getZdarzenia(s -> s instanceof Zadanie, day );
                for (var zadanie : zadania) {
                    System.out.println(zadanie);
                }
                System.out.println();
            }
        } else {
            System.out.println("Brak zadań");
        }
    }

    private static void wyswietlSpotkaniaOPriorytecie(Scanner scanner, Kalendarz kalendarz, DayOfWeek dzien) {
        Priorytet priorytet = dostanPriorytet(scanner);
        var spotkania = kalendarz.getZdarzenia(s -> s instanceof Spotkanie && ((Spotkanie) s).getPriorytet().equals(priorytet), dzien);
        if (spotkania == null) {
            System.out.println("Brak spotkan");
            return;
        }
        System.out.println();
        for (var spotkanie : spotkania) {
            System.out.println(spotkanie);
        }
    }

    private static void wyswietlZadaniaOStatusie(Scanner scanner, Kalendarz kalendarz, DayOfWeek dzien) {
        Status status = dostanStatus(scanner);
        var zadania = kalendarz.getZdarzenia(s -> s instanceof Zadanie && ((Zadanie) s).getStatus().equals(status), dzien);
        if (zadania == null) {
            System.out.println("Brak spotkan");
            return;
        }
        System.out.println();
        for (var zadanie : zadania) {
            System.out.println(zadanie);
        }
    }

    private static void wyswietlSpotkaniaOPriorytecieICzasie(Scanner scanner, Kalendarz kalendarz, DayOfWeek dzien) {
        Priorytet priorytet = dostanPriorytet(scanner);
        scanner.nextLine();
        System.out.println("Podaj godzinę rozpoczęcia spotkania [HH:MM]");
        var czas = dostanCzas(scanner.nextLine());
        var spotkania = kalendarz.getZdarzenia(
                (s) -> {
                    if (s instanceof Spotkanie spotkanie) {
                        return !spotkanie.getCzasStart().isBefore(czas) && spotkanie.getPriorytet().equals(priorytet);
                    }
                    return false;
                },
                dzien
        );
        if (spotkania == null) {
            System.out.println("Brak spotkan");
            return;
        }
        System.out.println();
        for (var spotkanie : spotkania) {
            System.out.println(spotkanie);
        }
    }

    private static void wyswietlZadaniaOStatusieICzasie(Scanner scanner, Kalendarz kalendarz, DayOfWeek dzien) {

        Status status = dostanStatus(scanner);
        scanner.nextLine();
        System.out.println("Podaj godzinę rozpoczęcia zadania [HH:MM]");
        var czas = dostanCzas(scanner.nextLine());
        var zadania = kalendarz.getZdarzenia(
                (s) -> {
                    if (s instanceof Zadanie zadanie) {
                        return zadanie.getCzasKoniec().isBefore(czas) && zadanie.getStatus().equals(status);
                    }
                    return false;
                },
                dzien
        );
        if (zadania == null) {
            System.out.println("Brak spotkan");
            return;
        }
        System.out.println();
        for (var zadanie : zadania) {
            System.out.println(zadanie);
        }
    }
}