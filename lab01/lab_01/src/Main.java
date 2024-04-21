import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("This is a program to calculations. You can calculate factorial, or count a sum from two numbers");
        menu();
    }
    public static void menu(){
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        while (run){
            System.out.println("\nIf you want to know a factorial, press f\nIf you want to know a sum press s\nIf you want exit, press e");
            String choose = scan.nextLine();
            switch (choose) {
                case "f" -> callingFactorial();
                case "s" -> callingSuma();
                case "e" -> run = false;
            }
        }

    }

    public static void callingFactorial(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a number, which factorial you want to know: ");
        long value = scan.nextLong();
        System.out.println("Factorial of " + value + " is " + Calculations.factorial(value));
    }
    public static void callingSuma(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input two numbers, between which you want to know a sum: ");
        long a = scan.nextLong();
        long b = scan.nextLong();
        System.out.println("Sum between " + a + " and " + b +" is " + Calculations.sum(a, b));
    }
}