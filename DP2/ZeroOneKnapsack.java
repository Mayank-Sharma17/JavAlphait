package DP2;

public class ZeroOneKnapsack { // Using Recursion O(2^n)
    public static int knapSack(int val[], int wt[], int W, int n) { // n-iteams
        if(W == 0 || n == 0) {
            return 0; // base case if there is no (0)iteams and if weight of our bag is 0 kg so we can't add anything so the profit is 0
        }

        if(wt[n-1] <= W) { // valid
            int ans1 = val[n-1]+knapSack(val, wt, W-wt[n-1], n-1); // iteam included
            int ans2 = knapSack(val, wt, W, n-1); // item excluded W is same
            return Math.max(ans1, ans2);
        } else { // not valid
            return knapSack(val, wt, W, n-1); // exclude if not valid means if W < wt[n-1]
        }
    }

    // Using DP memoization---------------------------------------------------------O(n*W)
    public static int knapSackMemo(int val[], int wt[], int W, int n, int dp[][]) { // n-iteams
        if(W == 0 || n == 0) {
            return 0; // base case if there is no (0)iteams and if weight of our bag is 0 kg so we can't add anything so the profit is 0
        }
        if(dp[n][W] != -1) {
            return dp[n][W]; // ans
        }

        if(wt[n-1] <= W) { // valid
            int ans1 = val[n-1]+knapSackMemo(val, wt, W-wt[n-1], n-1, dp); // iteam included
            int ans2 = knapSackMemo(val, wt, W, n-1, dp); // item excluded W is same
            dp[n][W] = Math.max(ans1, ans2); // phele store krliya us jagha pr then return 
            return dp[n][W];
        } else { // not valid
            dp[n][W] = knapSackMemo(val, wt, W, n-1, dp); // exclude if not valid means if W < wt[n-1]
            return dp[n][W];
        }
    }

    // Using DP Tabulation------------------------------------------------------------O(n*W)
    public static int knapSackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0; // initialize 0th col with 0
        }
        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = 0; // initialize 0th row with 0
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                int v = val[i-1]; // ith iteam ke value
                int w = wt[i-1]; // ith iteam ka weight

                if(w <= j) { // valid
                    int incProfit = v+dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else { // w > j invalid
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
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
        System.out.println(knapSackTab(val, wt, W));
        //System.out.println(knapSackMemo(val, wt, W, val.length, dp));
    }
}