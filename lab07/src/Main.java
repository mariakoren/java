import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("The program supports offers for the sale of apartments and houses");
        var scanner = new Scanner(System.in);
        var list = new ListOfferts();
        var running = true;
        while (running) {
            printMenu();
            switch (scanner.nextInt()) {
                case 0 -> addHouse(scanner, list);
                case 1 -> addApartment(scanner, list);
                case 2 -> displayCurrentHouses(list);
                case 3 -> displayCurrentApartments(list);
                case 4 -> displayCurrentHousesLocationArea(scanner, list);
                case 5-> displayCurrentApartmentsLocationPriceFloor(scanner, list);
                case 6 -> example(list);
                case 7 -> running = false;
                default -> System.out.println("Incorrect choice");
            }
        }
    }

    public static void printMenu(){
        System.out.println();
        System.out.println("0. Adding an offer for the sale of a house with the parameters");
        System.out.println("1. Adding an offer for the sale of an apartment with the parameters");
        System.out.println("2. Display of all current houses offers");
        System.out.println("3. Display of all current apartments offers");
        System.out.println("4. Display of all current houses offers in the specified location " +
                "with an area not less than the specified value");
        System.out.println("5. Display of all current offers  of apartments in the specified location " +
                "not more expensive than the specified value and from the specified floor upwards");
        System.out.println("6. Adding example objects");
        System.out.println("7. Exit");
    }

    public static House createHouse(Scanner scanner) {
        System.out.println("Adding a new house");
        scanner.nextLine();
        System.out.println("Enter a street");
        var street = scanner.nextLine();
        System.out.println("Enter a building number");
        var nrBuilding = scanner.nextLine();
        System.out.println("Enter a location");
        var location = scanner.nextLine();
        System.out.println("Enter a zipcode");
        var zipcode = scanner.nextLine();
        System.out.println("Enter an area");
        var area = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter a price");
        var price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter a plot area");
        var plotArea = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter an offer effective date (yyyy-MM-dd)");
        var offerEffectiveDateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate offerEffectiveDate = null;
        try {
            offerEffectiveDate = LocalDate.parse(offerEffectiveDateString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            return null;
        }
        return new House(street, nrBuilding, location, zipcode, area, price, plotArea, offerEffectiveDate);
    }

    public static void addHouse(Scanner scanner, ListOfferts list) {
        var house = createHouse(scanner);
        if (house != null) {
            try {
                list.addPlaceToLive(house);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("House creation failed due to invalid input.");
        }
    }

    public static Apartment createApartment(Scanner scanner) {
        System.out.println("Adding a new apartment");
        scanner.nextLine();
        System.out.println("Enter a street");
        var street = scanner.nextLine();
        System.out.println("Enter a building number");
        var nrBuilding = scanner.nextLine();
        System.out.println("Enter an apartment number");
        var nrApartment = scanner.nextLine();
        System.out.println("Enter a location");
        var location = scanner.nextLine();
        System.out.println("Enter a zipcode");
        var zipcode = scanner.nextLine();
        System.out.println("Enter an area");
        var area = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter a floor number");
        var nrFloor = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter a price");
        var price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter an offer effective date (yyyy-MM-dd)");
        var offerEffectiveDateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate offerEffectiveDate = null;
        try {
            offerEffectiveDate = LocalDate.parse(offerEffectiveDateString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            return null;
        }
        return new Apartment(street, nrBuilding, nrApartment,location, zipcode, area, nrFloor, price, offerEffectiveDate);
    }

    public static void addApartment(Scanner scanner, ListOfferts list) {
        var apartment = createApartment(scanner);
        if (apartment != null) {
            try {
                list.addPlaceToLive(apartment);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("House creation failed due to invalid input.");
        }
    }

    public static void displayCurrentHouses(ListOfferts list){
        var houses = list.getPlaceToLive(p -> p instanceof House && !((House) p).getOfferEffectiveDate().isBefore(LocalDate.now()));
        if (houses == null){
            System.out.println("No current houses");
            return;
        }
        for (var house: houses){
            System.out.println(house);
        }
    }

    public static void displayCurrentApartments(ListOfferts list){
        var apartments = list.getPlaceToLive(p -> p instanceof Apartment && !((Apartment) p).getOfferEffectiveDate().isBefore(LocalDate.now()));
        if (apartments == null){
            System.out.println("No current apartments");
            return;
        }
        for (var apartment: apartments){
            System.out.println(apartment);
        }
    }

    public static void displayCurrentHousesLocationArea(Scanner scanner, ListOfferts list){
        scanner.nextLine();
        System.out.println("Enter a location");
        var location = scanner.nextLine();
        System.out.println("Enter an area");
        var area = Double.parseDouble(scanner.nextLine());
        var houses = list.getPlaceToLive(
                (s) -> {
                    if (s instanceof House house) {
                        return !house.getOfferEffectiveDate().isBefore(LocalDate.now()) && house.getLocation().equals(location) && house.getArea()>=area;
                    }
                    return false;
                }
        );
        if (houses == null){
            System.out.println("No current houses");
            return;
        }

        for (var house: houses){
            System.out.println(house);
        }
    }

    public static void displayCurrentApartmentsLocationPriceFloor(Scanner scanner, ListOfferts list){
        scanner.nextLine();
        System.out.println("Enter a location");
        var location = scanner.nextLine();
        System.out.println("Enter a price");
        var price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter a floor");
        var floor = Double.parseDouble(scanner.nextLine());

        var apartments = list.getPlaceToLive(
                (s) -> {
                    if (s instanceof Apartment apartment) {
                        return !apartment.getOfferEffectiveDate().isBefore(LocalDate.now())
                                && apartment.getLocation().equals(location)
                                && apartment.getPrice() <= price
                                && apartment.getNrFloor() >= floor;
                    }
                    return false;
                }
        );
        if (apartments == null){
            System.out.println("No current apartments");
            return;
        }

        for (var apartment: apartments){
            System.out.println(apartment);
        }
    }

    public static void example(ListOfferts list){
        list.addPlaceToLive(new House("Main Street", "123", "Gdansk", "10001", 150.0, 300000.0, 500.0, LocalDate.of(2024, 6, 15)));
        list.addPlaceToLive(new House("Second Street", "456", "Gdansk", "90001", 200.0, 500000.0, 600.0, LocalDate.of(2024, 6, 10)));
        list.addPlaceToLive(new House("Third Street", "789", "Gdansk", "60601", 250.0, 450000.0, 700.0, LocalDate.of(2024, 3, 5)));
        list.addPlaceToLive(new House("Fourth Street", "101", "Gdansk", "77001", 300.0, 600000.0, 800.0, LocalDate.of(2024, 4, 20)));
        list.addPlaceToLive(new House("Fifth Street", "202", "Krakow", "85001", 180.0, 350000.0, 550.0, LocalDate.of(2024, 5, 15)));
        list.addPlaceToLive(new House("Sixth Street", "303", "Krakow", "19101", 220.0, 400000.0, 650.0, LocalDate.of(2024, 6, 10)));
        list.addPlaceToLive(new House("Seventh Street", "404", "Krakow", "78201", 190.0, 380000.0, 600.0, LocalDate.of(2024, 7, 5)));
        list.addPlaceToLive(new House("Eighth Street", "505", "Krakow", "92101", 260.0, 480000.0, 720.0, LocalDate.of(2024, 8, 20)));
        list.addPlaceToLive(new Apartment("Main Street", "123", "1A", "Gdansk", "10001", 80.0, 3, 250000.0, LocalDate.of(2024, 6, 15)));
        list.addPlaceToLive(new Apartment("Second Street", "456", "2B", "Gdansk", "90001", 90.0, 5, 300000.0, LocalDate.of(2024, 6, 10)));
        list.addPlaceToLive(new Apartment("Third Street", "789", "3C", "Gdansk", "60601", 85.0, 2, 270000.0, LocalDate.of(2024, 3, 5)));
        list.addPlaceToLive(new Apartment("Fourth Street", "101", "4D", "Gdansk", "77001", 95.0, 4, 320000.0, LocalDate.of(2024, 4, 20)));
        list.addPlaceToLive(new Apartment("Fifth Street", "202", "5E", "Krakow", "85001", 88.0, 1, 260000.0, LocalDate.of(2024, 5, 15)));
        list.addPlaceToLive(new Apartment("Sixth Street", "303", "6F", "Krakow", "19101", 92.0, 3, 290000.0, LocalDate.of(2024, 6, 10)));
        list.addPlaceToLive(new Apartment("Seventh Street", "404", "7G", "Krakow", "78201", 87.0, 2, 280000.0, LocalDate.of(2024, 7, 5)));
        list.addPlaceToLive(new Apartment("Eighth Street", "505", "8H", "Krakow", "92101", 93.0, 5, 310000.0, LocalDate.of(2024, 8, 20)));
    }
}

