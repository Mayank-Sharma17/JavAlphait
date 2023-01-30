package DP5;
// at any moment the no. of down strokes '\' cannot be more then no. of up strokes '\'
public class MountainRanges {
    public static int mountainRange(int n) { // O(n^2)
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<n+1; i++) { // i pairs=> mountain ranges possible
            for(int j=0; j<i; j++) {
                int insidepairs = dp[j];
                int outsidepairs = dp[i-j-1];
                dp[i] += insidepairs*outsidepairs;
            }
        }
        return dp[n]; // n pairs
    }
    public static void main(String[] args) {
        int n = 4; // 4 pairs given means '/\''/\''/\''/\' 
        System.out.println(mountainRange(n)); 
    }
}
