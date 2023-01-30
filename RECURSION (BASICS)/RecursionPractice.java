public class RecursionPractice {
    
    static String digits[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void printDigits(int number) { 
        if(number == 0) { // base case
            return;
        }
        int lastDigit = number%10; // kaam
        printDigits(number/10);
        System.out.print(digits[lastDigit]+ " ");
    }


    public static void alloccurences(int arr[], int i, int key) { // all occurences i of key
        // Base Case
        if (i == arr.length) {
            return;
        }
        // kaam
        if (arr[i] == key) {
            System.out.print(i + " ");
        }
        alloccurences(arr, i + 1, key);
    }

    
    public static int length(String str) { // String length using Recursion
        if(str.length() == 0) {
            return 0;
        }
        
        return length(str.substring(1)) + 1;
    }

    
    // Function to count substrings
    // with same first and
    // last characters
    static int countSubstrs(String str, int i, int j, int n) {
        // base cases
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }    
        
        int res = countSubstrs(str, i + 1, j, n - 1) +
                  countSubstrs(str, i, j - 1, n - 1) -
                  countSubstrs(str, i + 1, j - 1, n - 2);        
     
        if (str.charAt(i) == str.charAt(j)) {
            res++;
        } 
        return res;
    }

    public static void towerOfHanoi(int n, String src, String helper, String dest) { // *TOWER OF HANOI*
        if(n == 1) {
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);
        return;
        }
        
        //transfer top n-1 from src to helper using dest as 'helper'
        towerOfHanoi(n-1, src, dest, helper);
        
        //transfer nth from src to dest
        System.out.println("transfer disk " + n + " from " + src + " to " + helper);
        
        //transfer n-1 from helper to dest using src as 'helper'
        towerOfHanoi(n-1, helper, src, dest);
    }

    public static void main(String[] args) {
        // int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // alloccurences(arr, 0, 2);

        //printDigits(015);

        // String str = "abcde";
        // System.out.println(length(str));

        // String str = "abcab";
        // int n = str.length();
        // System.out.print(countSubstrs(str, 0, n - 1, n));

        int n = 3;
        towerOfHanoi(n, "S", "H", "D");

    }

}
