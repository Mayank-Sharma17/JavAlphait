package GREEDY_ALG;

public class MaxStrpartn { // time C O(n) and spce C O(1)
    static int BalancedPartition(String str, int n) {
        if(n==0)
        return 0; // of string len is zero

        int r=0, l=0;
        int maxpart = 0;

        for(int i=0; i<n; i++) {
            if(str.charAt(i) == 'R') {
                r++;
            } else if(str.charAt(i) == 'L') {
                l++;
            }

            if(r == l)
            maxpart++;
        }
        return maxpart;
    }
    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        int n = str.length();

        System.out.print("Maximum balanced String partition is = " + BalancedPartition(str,n));
    }
}
