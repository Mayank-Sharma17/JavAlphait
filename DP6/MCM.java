package DP6;

import java.util.Arrays;

public class MCM { // Matrix chain multiplication 
    // Using Recursion 
    public static int mcm(int arr[], int i, int j) {
        // where i -> starting point
        //       j -> ending point
        //       k -> start --> end
        if(i == j) {
            return 0; // single matrix case -> base case
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) { // k -> cuts
            int cost1 = mcm(arr, i, k); // Ai -> Ak tak => arr[i-1]*arr[k]
            int cost2 = mcm(arr, k+1, j); // Ai+1 -> Aj tak ka mcm => arr[k]*arr[j]
            int cost3 = arr[i-1]*arr[k]*arr[j];

            int finalcost = cost1+cost2+cost3;
            ans = Math.min(ans, finalcost);
        }
        return ans;
    }

    // Using recursion + Memoization dp T>C O(n^2)
    public static int mcmMemo(int arr[], int i, int j, int dp[][]) {
        if(i == j) {
            return 0;
        }
        if(dp[i][j] != -1) {  
            return dp[i][j]; // already calulated
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) { 
            int cost1 = mcmMemo(arr, i, k, dp); // Ai -> Ak tak => arr[i-1]*arr[k]
            int cost2 = mcmMemo(arr, k+1, j, dp); // Ai+1 -> Aj tak ka mcm => arr[k]*arr[j]
            int cost3 = arr[i-1]*arr[k]*arr[j]; // final cost

            ans = Math.min(ans, cost1+cost2+cost3); // min of the final cost and ans                                           
        }
        return dp[i][j] = ans; // store 
    }

    // using Tabulation
    public static int mcmTab(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        // initialize
        for(int i=0; i<n; i++) {
            dp[i][i] = 0; // single matrix row = col
        }

        // bottom up
        for(int len = 2; len <= n-1; len++) {
            for(int i = 1; i <= n-len; i++) {
                int j = i+len-1; // col
                dp[i][j] = Integer.MAX_VALUE; // inititlalize
                for(int k=i; k<=j-1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3}; // n=5
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1); // filling the dp row wise
        }
        System.out.println(mcmMemo(arr, 1,n-1, dp));
        System.out.println(mcmTab(arr));
    }
}
