package DP5;

public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        //intilialize
        dp[0][0] = true; // base case
        for(int i=1; i<n+1; i++) { // pattern = " "
            dp[i][0] = false; // koe pattern nahe hai match krne ke lea
        }

        for(int j=1; j<m+1; j++) { // s = " "
            if(p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        //dp Tabulation
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                //case => ith char => jth char || jth char == ? in p
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') { // ? = bhe sirf charcter se match kar sakta hai
                    dp[i][j] = dp[i-1][j-1]; // next vaalo ko dekh lo
                } else if(p.charAt(j-1) == '*') { // agar star hai toh multi charcter kuch bhe hoskta hai to pattern j ke len vahe rahege
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false; // agar or koe case hai toh jase char he match nahe hore toh false
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s = "aa";
        String p = "*"; // true 
        System.out.println(isMatch(s, p));
    }
}