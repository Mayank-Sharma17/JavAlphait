package DP3;

public class RodCutting { // variation of unbounded knapsack  
    public static int rodCutting(int length[], int prices[], int totRod) { // using Tabulation DP
        int n = prices.length; // or length.length;
        int dp[][] = new int[n+1][totRod+1];
        //initialize the dp array
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<totRod+1; j++) {
                if(i==0 || j==0) {
                    // means the there is a rod of length 0 on j idx and if the val is 0 on ith idx then we canot obtain any min or max profit cannot sell
                    dp[i][j] = 0; // initiliaze no need in java
                }
            }
        }
        for(int i=1; i<n+1; i++) { // O(n*totRod)
            for(int j=1; j<totRod+1; j++) {
                if(length[i-1] <= j) {
                    dp[i][j] = Math.max(prices[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][totRod];
    } 
    private static void print(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8}; // length = wt
        int prices[] = {1, 5, 8, 9, 10, 17, 17, 20}; // prices = val
        int totRod = 8; // allowed length of rod // totRod = W
        System.out.println(rodCutting(length, prices, totRod));   
    }
}
