import java.util.*;       // checking if a number input by the user is a palindrome or not ex 121 

public class funpq1 {

    public static boolean isPalindrome(int number) {
        int palindrome = number;
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }
        if (number == reverse) { // if a reverse of a number is eqal to the mean then a number is
                                 // palindrome in java
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int palindrome = sc.nextInt(); // number copied in palindrome variable

        if (isPalindrome(palindrome)) { // calling function isPalindrome
            System.out.println("The number " + palindrome + " is a palindrome");

        } else {
            System.out.println("The number " + palindrome + " is not a plaindrome");
        }
sc.close();
    }

}
