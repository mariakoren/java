import java.util.Scanner;

public class Calculations {
        public static long factorial(long n){
        long factorial = 1;
        for (long i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public  static long sum(long a, long b){
        long sum = 0;
        for (long i = a; i <= b ; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
