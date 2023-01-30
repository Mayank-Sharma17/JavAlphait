import java.util.*;

public class function {
    public static void printHelloWorld() {
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        return;
    }

    public static void calculateSum(int a, int b) {
       
        int sum = a + b;
        System.out.println("Sum is :" + sum);

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        calculateSum(a, b);
sc.close();// not neccessary just removing warning
    }

}