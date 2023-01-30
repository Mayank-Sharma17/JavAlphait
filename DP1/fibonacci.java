package DP1;

public class fibonacci {
    public static int fib(int n) { // normal reecursio time comp O(2^N)
        if(n == 0 || n == 1) {
            return n; // phele se pata hai
        }
        return fib(n-1)+fib(n-2); // recursion call 
    }

    // using DP memoization/memory - storage store krlo time comp O(N)
    public static int fibMemoization(int n, int f[]) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(f[n] != 0) { // in array fibonacci is already calculated
            return f[n];
        }
        f[n] = fibMemoization(n-1, f)+fibMemoization(n-2, f); // store that f[n] agar calculated nahe hai toh
        return f[n]; 
    }

    //using DP tabulation/table array 2d arr hashtable .....
    public static int fibTabulation(int n) { // time comp O(N)
        int dp[] = new int[n+1]; // step 1 initialization
        dp[1] = 1; // krdiya initialize with base cases dp[0] = 0 int C++
        
        for(int i=2; i<dp.length; i++) {
            dp[i] = dp[i-1]+dp[i-2]; // step 2nd meaning -- matlb ke ith fibonacci = to pichle 2 index pr store fibonacci ka sum hai 
        }
        return dp[n]; // array is no filled small to large then return
    }
    public static void main(String[] args) {
        int n = 5;
        int f[] = new int[n+1]; // 0 0 0 0..........assigned in array
        System.out.println(fibMemoization(n, f));
        System.out.println(fibTabulation(n));
    }
}
