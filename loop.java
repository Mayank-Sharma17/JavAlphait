import java.util.*;

public class loop {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int number;
        int choice;
        int evensum = 0;
        int oddsum = 0;

        do {
            System.out.println("enetr your number :");
            number = sc.nextInt();

            if (number % 2 == 0) {

                evensum += number;
            } else {

                oddsum += number;
            }
// taking choice form the user if he want to continue the code if we not add this then the loop is
// infinite 
System.out.println("do you want to continue? press 1 for yes or 0 for no");
choice = sc.nextInt();

        } while (choice==1);
        
        System.out.println("the sum of even integer" + evensum);

        System.out.println("the sum of odd integer" + oddsum);
 sc.close();       
    }
}