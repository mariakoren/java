import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("Ten program służy do wylicznia pól powierzchni oraz objętości walca");
        Scanner scan = new Scanner(System.in);
        Walec walec = new Walec();
//        Walec walec = new Walec(7,8)
        boolean run = true;
        while (run){
            pokazMenu();
            String choose = scan.nextLine();
            switch (choose) {
                case "u" -> ustawienieWartosci(walec);
                case "w" -> wyswietlanieWartosci(walec);
                case "p" -> wyliczaniePolPowierzchni(walec);
                case "o" -> wyliczanieObjetosci(walec);
                case "e" -> run = false;
            }
        }
    }
    public static void pokazMenu(){
        System.out.println("Jeżeli chcesz ustawić wartości dla walca, naciści u");
        System.out.println("Jeżeli chcesz wyswietlic wartości dla walca, naciści w");
        System.out.println("Jeżeli chcesz wyliczyć pole powierzchni podstawy walca, naciści p");
        System.out.println("Jeżeli chcesz wyliczyć pole powierzchni bocznej walca, naciści b");
        System.out.println("Jeżeli chcesz wyliczyć pole powierzchni całkowitej walca, naciści c");
        System.out.println("Jeżeli chcesz wyliczyć objętość walca, naciści o");
        System.out.println("Jeżeli chcesz wyjść z programu, naciści e");
    }
    public  static  void ustawienieWartosci(Walec walec){
        System.out.println("Wprowadzaj dane z przecinkiem");
        Scanner scan = new Scanner(System.in);
        System.out.println("Wprowadź promien podstawy: ");
        double promienPodstawy = scan.nextDouble();
        walec.setPromienPodstawy(promienPodstawy);
        System.out.println("Wprowadź wysokość: ");
        double wysokosc = scan.nextDouble();
        walec.setWysokosc(wysokosc);
    }
    public static void wyswietlanieWartosci(Walec walec){
        System.out.println("Promien podstawy: " + walec.getPromienPodstawy());
        System.out.println("Wysokość: " + walec.getWysokosc());
    }
    public static void wyliczaniePolPowierzchni(Walec walec){
        System.out.println("Pole powierzchni podstawy: " + walec.polePowierzchniPodstawy());
        System.out.println("Pole powierzchni bocznej: " + walec.polePowierzchniBocznej());
        System.out.println("Pole powierzchni całkowitej: " + walec.polePowierzchniCalkowitej());


    }
    public static void wyliczanieObjetosci(Walec walec){
        System.out.println("Objętość: " + walec.objetosc());
    }

}