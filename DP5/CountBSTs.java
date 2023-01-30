package DP5;

public class CountBSTs {
    public static int countBSTs(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1; 

        for(int i=2; i<n+1; i++) {
            for(int j=0; j<i; j++) {
                //Ci = Cj*Ci-j-1
                dp[i] += dp[j]*dp[i-j-1]; // left * right
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(countBSTs(n));
    }
}
