import java.util.*;

public class funpq {
    public static double average(double x, double y, double z) {
        // double avg = (x+y+z)/3;
        // return avg; // both ways are correct
        return (x + y + z) / 3;

    }

    public static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;

        } else {
            return false;

        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("enter an integer");
        num = sc.nextInt();

        // System.out.print("enter your first number");
        // double x = sc.nextDouble();
        // System.out.print("enter your second number");
        // double y = sc.nextDouble();
        // System.out.print("enter your third number");
        // double z = sc.nextDouble();
        // // yaha par ham function ko call laga kar usee ek variable mae store kara kar
        // fir use print
        // // kara sakte the... but hamne yaha use direct print mae he call laga de
        // System.out.print("the everage is " + average(x, y, z) + "\n");

        sc.close();
        if (isEven(num)) { // calling isEven(num) function and passing our num variable for checkhing
            System.out.print("number is even");

        } else {
            System.out.print("number is odd");
        }

    }

}
