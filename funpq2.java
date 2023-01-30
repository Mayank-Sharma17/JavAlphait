import java.util.*;

public class funpq2 {
    public static int sumofdig(int n) {

        int sumofdigits = 0;

        while (n > 0) {
            int lastdig = n % 10;
            sumofdigits += lastdig;
            n = n / 10;
        }

        return sumofdigits;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an number");
        int number = sc.nextInt();

        System.out.println("the sum of digits is " + sumofdig(number));
        sc.close();
    }

}
