public class PrintXpowN {

    public static int power(int x, int n) { // calculating x^n using recursion - O(n)
        if( n == 0 ) {
            return 1;
        }
        return x * power(x, n-1);        
    }

    public static int optimizedpower(int a, int n) { // O(logn)
        if( n == 0 ) {
            return 1;
        }
        int halfpower = optimizedpower(a, n/2); // one call 
        int halfpowerSq = halfpower * halfpower;

        // is n is odd
        if(n%2 != 0) {
            halfpowerSq = a * halfpowerSq;
        }
        return halfpowerSq;
    }
    
    public static void main(String args[]) {
        System.out.println(optimizedpower(5, 2));
    }   
}

