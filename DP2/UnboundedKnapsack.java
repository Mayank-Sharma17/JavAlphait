package DP2;

public class UnboundedKnapsack {
    public static int UnboundedknapSack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i=0; i<n+1; i++) {
            dp[i][0] = 0; // initialize 0th col with 0
        }
        for(int j=0; j<W+1; j++) {
            dp[0][j] = 0; // initialize 0th row with 0
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                // int v = val[i-1]; // ith iteam ke value
                // int w = wt[i-1]; // ith iteam ka weight

                if(wt[i-1] <= j) { // valid
                    // int incProfit = v+dp[i-1][j-w];
                    // int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);
                } else { // w > j invalid
                    //int excProfit = dp[i-1][j];
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];
    }
    public static void print(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30}; // value given in rupees 
        int wt[] = {2, 5, 1, 3, 4}; // wwight of iteam in (kg)
        int W = 7; // allowed weight/capacity
        int dp[][] = new int [val.length+1][W+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1; // initializing 2d array with -1
            }
        }
        System.out.println(UnboundedknapSack(val, wt, W));
    }
}
