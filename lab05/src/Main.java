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
                case 0 -> dostanDzien(scanner, (day) -> dodajSpotkanie(scanner, kalendarz, day));
                case 1 -> dostanDzien(scanner, (day) -> usunSpotkanie(scanner, kalendarz, day));
                case 2 -> dostanDzien(scanner, (day) -> wyswietlSpotkania(kalendarz, day));
                case 3 -> dostanDzien(scanner, (day) -> wyswietlSpotkaniaOPriorytecie(scanner, kalendarz, day));
                case 4 -> dostanDzien(scanner, (day) -> wyswietlSpotkaniaZaczynajaceSiePo(scanner, kalendarz, day));
                case 5 -> dostanDzien(scanner, (day) -> wyswietlSpotkaniaPomiedzy(scanner, kalendarz, day));
                case 6 -> dostanDzien(scanner, (day) -> wyswietlSpotkaniaOPriorytecieICzasie(scanner, kalendarz, day));
                case 7 -> przyklad(kalendarz);
                case 8 -> wszystkie(kalendarz);
                case 9 -> running = false;
                default -> System.out.println("Niepoprawny wybór");
            }
        }
    }

    public static void printMenu(){
        System.out.println();
        System.out.println("0. Dodaj nowe spotkanie");
        System.out.println("1. Usuń spotkanie");
        System.out.println("2. Wyświetl spotkania w wybranym dniu");
        System.out.println("3. Wyświetl spotkania o priorytecie w wybranym dniu");
        System.out.println("4. Wyświetl spotkania zaczynające się nie wcześniej niż podany czas");
        System.out.println("5. Wyświetl spotkania odbywające się między godzinami");
        System.out.println("6. Wyświetl spotkania zaczynające się nie wcześniej niż podany czas i o podanym priorytecie");
        System.out.println("7. Dodaj przykładowe spotkania");
        System.out.println("8. Pokaż wszystkie spotkania");
        System.out.println("9. Wyjście");
    }

    private static void przyklad(Kalendarz kalendarz) {
        var spotkanie1 = new Spotkanie("desc1", LocalTime.of(8, 0), LocalTime.of(9, 0), Priorytet.NORMALNE);
        var spotkanie2 = new Spotkanie("desc2", LocalTime.of(9, 0), LocalTime.of(10, 0), Priorytet.WYSOKIE);
        var spotkanie3 = new Spotkanie("desc3", LocalTime.of(10, 0), LocalTime.of(11, 0), Priorytet.NAJWYŻSZE);
        var spotkanie4 = new Spotkanie("desc4", LocalTime.of(11, 0), LocalTime.of(12, 0), Priorytet.NORMALNE);
        var spotkanie5 = new Spotkanie("desc5", LocalTime.of(12, 0), LocalTime.of(13, 0), Priorytet.WYSOKIE);
        var spotkanie6 = new Spotkanie("desc6", LocalTime.of(13, 0), LocalTime.of(16, 0), Priorytet.NAJWYŻSZE);
        var spotkanie7 = new Spotkanie("desc7", LocalTime.of(14, 0), LocalTime.of(15, 0), Priorytet.NORMALNE);

        try {
            kalendarz.addSpotkanie(DayOfWeek.MONDAY, spotkanie1);
            kalendarz.addSpotkanie(DayOfWeek.MONDAY, spotkanie2);
            kalendarz.addSpotkanie(DayOfWeek.MONDAY, spotkanie3);
            kalendarz.addSpotkanie(DayOfWeek.MONDAY, spotkanie4);
            kalendarz.addSpotkanie(DayOfWeek.MONDAY, spotkanie5);
            kalendarz.addSpotkanie(DayOfWeek.MONDAY, spotkanie6);
            kalendarz.addSpotkanie(DayOfWeek.MONDAY, spotkanie7);
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
            kalendarz.addSpotkanie(day, spotkanie);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void usunSpotkanie(Scanner scanner, Kalendarz kalendarz, DayOfWeek dzien) {
        System.out.println("Podaj godzinę rozpoczęcia spotkania [HH:MM]");
        var czasRozpoczecia = dostanCzas(scanner.nextLine());
        System.out.println("Podaj godzinę zakończenia spotkania [HH:MM]");
        var czasZakonczenia = dostanCzas(scanner.nextLine());
        var spotkania = kalendarz.getSpotkania((s) -> s.getCzasStart().equals(czasRozpoczecia) && s.getCzasKoniec().equals(czasZakonczenia), dzien);
        if (spotkania.size() == 1) {
            kalendarz.getDane().get(dzien).remove(spotkania.get(0));
        } else {
            System.out.println("znaleziono więcej niż jedno spotkanie!");
            System.out.println("usunąć je wszystkie? [y/N]");
            var usr = scanner.next().toLowerCase();
            switch (usr) {
                case "y" ->
                        spotkania.forEach((x) -> {kalendarz.getDane().get(dzien).remove(x);});
                default -> System.out.println("nie usuwam");
            }
        }
    }

    private static void wyswietlSpotkania(Kalendarz kalendarz, DayOfWeek day) {
        var help = kalendarz.getDane();
        if (help != null){
            var spotkania = kalendarz.getDane().get(day);
            if (spotkania == null) {
                System.out.println("Brak spotkań w wybranym dniu");
            } else {
                for (var spotkanie : spotkania) {
                    System.out.println(spotkanie);
                }
                System.out.println();
            }
        } else {
            System.out.println("Brak spotkań");
        }



    }

    private static void wyswietlSpotkaniaOPriorytecie(Scanner scanner, Kalendarz kalendarz, DayOfWeek dzien) {
        Priorytet priorytet = dostanPriorytet(scanner);
        var spotkania = kalendarz.getSpotkania((s) -> s.getPriorytet().equals(priorytet), dzien);
        if (spotkania == null) {
            System.out.println("Brak spotkan");
            return;
        }
        System.out.println();
        for (var spotkanie : spotkania) {
            System.out.println(spotkanie);
        }
    }

    private static void wyswietlSpotkaniaPomiedzy(Scanner scanner, Kalendarz kalendarz, DayOfWeek dzien) {
        System.out.println("Podaj godzinę rozpoczęcia spotkania [HH:MM]");
        var czasRozpoczecia = dostanCzas(scanner.nextLine());
        System.out.println("Podaj godzinę zakończenia spotkania [HH:MM]");
        var czasZakonczenia = dostanCzas(scanner.nextLine());
        var spotkania = kalendarz.getSpotkania((s) -> {
            var cStart = s.getCzasStart().compareTo(czasRozpoczecia);
            var cStop = s.getCzasKoniec().compareTo(czasZakonczenia);
            return cStart >= 0 && cStop <= 0;
        }, dzien);
        if (spotkania == null) {
            System.out.println("Brak spotkan");
            return;
        }
        System.out.println();
        for (var spotkanie : spotkania) {
            System.out.println(spotkanie);
        }
    }

    private static void wyswietlSpotkaniaOPriorytecieICzasie(Scanner scanner, Kalendarz kalendarz, DayOfWeek dzien) {
        Priorytet priorytet = dostanPriorytet(scanner);
        scanner.nextLine();
        System.out.println("Podaj godzinę rozpoczęcia spotkania [HH:MM]");
        var czas = dostanCzas(scanner.nextLine());
        var spotkania = kalendarz.getSpotkania(
                        (s) -> {return !s.getCzasStart().isBefore(czas) && s.getPriorytet().equals(priorytet);},
                        dzien);
        if (spotkania == null) {
            System.out.println("Brak spotkan");
            return;
        }
        System.out.println();
        for (var spotkanie : spotkania) {
            System.out.println(spotkanie);
        }
    }

    private static void wyswietlSpotkaniaZaczynajaceSiePo(Scanner scanner, Kalendarz kalendarz, DayOfWeek dzien) {
        System.out.println("Podaj godzinę");
        var czas = dostanCzas(scanner.nextLine());
        var spotkania = kalendarz.getSpotkania(
                        (s) -> {return !s.getCzasStart().isBefore(czas);},
                        dzien);
        if (spotkania == null) {
            System.out.println("Brak spotkan");
            return;
        }
        System.out.println();
        for (var spotkanie : spotkania) {
            System.out.println(spotkanie);
        }
    }
}