
public class function1 {
    public static boolean isPrime(int n) { // Functions for checking a no. is prime or not
        if (n == 2) { // corner case
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primesInRange(int n) { // Funtion of printing prime no's using above function
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
        // System.out.println(); //next line
    }

    public static void binToDec(int binNum) { // Function of conversion of binary no. to decimal no.
        int myNum = binNum;
        int pow = 0;
        int decNum = 0;

        while (binNum > 0) {
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit * (int) Math.pow(2, pow));
            pow++;
            binNum = binNum / 10;
        }
        System.out.println("decimal of" + myNum + "=" + decNum);
    }

    public static void decToBin(int n) { // function of conversion of decimal no. to binary no.
        int myNum = n;
        int pow = 0;
        int binNum = 0;

        while (n > 0) {
            int rem = n % 2;
            binNum = binNum + (rem * (int) Math.pow(10, pow));
            pow++;
            n = n / 2;
        } 
        System.out.println("binary form of" + myNum + "=" + binNum);
    }

    public static void main(String args[]) {                     //>>>>>>>> MAIN FUNTION <<<<<<<
        // primesInRange(20); // prime no form 2 to 20
        // binToDec(101);
        //  decToBin(5);
        
    }
}