package DP4;

public class LongestCommonSubstring { // using dp Tabulation tc = O(n*m)
    public static int longestSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        int ans = 0;
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0; // reset substring
                }
            }
        }
        print(dp);
        return ans;
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
        String str1 = "ABCDE";
        String str2 = "ABGCE"; // here the longestCommon SS is "AB"
        System.out.println(longestSubstring(str1, str2));
    }
}
