public class TilingProblem {
    
    public static int tilingProblem(int n) { // n - length of floor
        // base case
        if( n == 0 || n == 1 ) {
            return 1;
        }
        // kaam
        // vertical choice
        int fnm1 = tilingProblem(n-1);
        // horizontal choice
        int fnm2 = tilingProblem(n-2);
        // total ways
        int totways = fnm1 + fnm2;
        return totways;
    }
     public static void main(String[] args) {
        System.out.println(tilingProblem(4));
    }
    
}


