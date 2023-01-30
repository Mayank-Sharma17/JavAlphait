package DP5;

import java.util.Arrays;

public class CatalansNumber {
    // using Recursion
    public static int catalan(int n) {
        if(n == 0 || n == 1) {
            return 1; // catalan of 0 and 1 is 1
        }
        int ans = 0; // Cn
        for(int i=0; i<n; i++) {
            ans += catalan(i)*catalan(n-i-1); 
        }
        return ans;
    }

    // using Recursion+Memoization
    public static int catalanMemo(int n, int dp[]) {
        if(n==0 || n==1) {
            return 1;
        }
        if(dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            ans += catalanMemo(i, dp)*catalanMemo(n-i-1, dp);
        }
        return dp[n] = ans; // store in the dp
    }

    // using Tabulation
    public static int catalanTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1; // initialize dp with the BC
        dp[1] = 1;
        
        for(int i=2; i<=n; i++) { // Ci
            for(int j=0; j<i; j++) {
                dp[i] += dp[j]*dp[i-j-1]; // Ci = Cj*Ci-j-1
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        //System.out.println(catalan(n));
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1); // initialize dp with -1
        System.out.println(catalanMemo(n, dp));
        System.out.println(catalanTab(n));
    }
}
