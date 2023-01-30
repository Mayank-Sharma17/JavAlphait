package DP4;

public class LCSLongestCommonSubsequence {
    public static int lcs(String str1, String str2, int n, int m) {
        // n and m are the lengths of both the strigs str1 and str 2
        // here we using recursion top down
        if(n == 0 || m == 0) {
            return 0; // base case if length of both string is zero there is no length of lcs
        }

        // if the the last char are same 
        if(str1.charAt(n-1) == str2.charAt(m-1)) { // comparing last char
            return lcs(str1, str2, n-1, m-1)+1; // dono str ke leng ko -1 
        } else { // different toh 2 ans nikalo ek baar str1 ke length -1 kro or ek baar str2 ke leng ko -1 kro
            int ans1 = lcs(str1, str2, n-1, m);
            int ans2 = lcs(str1, str2, n, m-1);
            return Math.max(ans1, ans2); // return longest lcs
        }
    }

    // now using memoization + recursion
    public static int lcsMemo(String str1, String str2, int n, int m, int dp[][]) {
        if(n==0 || m==0) {
            return 0;
        }

        if(dp[n][m] != -1) return dp[n][m]; // direct return if not -1

        if(str1.charAt(n-1) == str2.charAt(m-1)) { // same char
            return dp[n][m] = lcsMemo(str1, str2, n-1, m-1, dp)+1;
        } else { // diff char
            int ans1 = lcsMemo(str1, str2, n-1, m, dp);
            int ans2 = lcsMemo(str1, str2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2); // store
        }
    } 

    // using Tabulation (Bottom Top) and time comp O(n*m)
    public static int lcsTab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        // for(int i=0; i<n+1; i++) { // no need in java
        //     dp[i][0] = 0; // 1st col initlialize with 0
        // }
        // for(int j=0; j<m+1; j++) {
        //     dp[0][j] = 0; // 1st row initialize with 0
        // }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2); // store
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace"; // here lcs is "ace" or length 3
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1]; // initialize with -1 everywhere
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(lcsMemo(str1, str2, n, m, dp));
        System.out.println(lcsTab(str1, str2));
    }
}
