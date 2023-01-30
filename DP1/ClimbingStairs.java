package DP1;

public class ClimbingStairs {
    public static int countWays(int n) { // noraml recursive fxn O(2^N)
        if(n==0) {
            return 1; // ground is ground tak ke 1 way
        }
        if(n<0) {
            return 0; // o ways these are base cases
        }
        return countWays(n-1)+countWays(n-2);
    }

    // using DP - memoization O(N)
    public static int countWaysMemo(int n, int ways[]) {
        if(n==0) {
            return 1;
        } 
        if(n<0) {
            return 0;
        }
        ways[n] = countWaysMemo(n-1, ways)+countWaysMemo(n-2, ways); // store karlo then return
        return ways[n];
    }

    // using DP - tabulation O(N) this is iteraative 
    public static int countWaysTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1; // phele se pata hai now start filling
        for(int i=1; i<dp.length; i++) {
            if(i==1) {
                dp[i] = dp[i-1]+0; // 0 matlb or -ve i = 1 -- 0 or -1 kea lea 
            } else { // i>1 vaale 
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int ways[] = new int[n+1];
        System.out.println(countWaysMemo(n, ways));
        System.out.println(countWaysTab(n));
    }
}
