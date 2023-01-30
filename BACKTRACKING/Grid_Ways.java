public class Grid_Ways {

    public static int countways(int r, int c) {
        // base case
        if(r == 1 || c == 1 ) {
            return 1;
        }
        int left = countways(r-1, c);
        int right = countways(r, c-1);
        return left+right;
    }

    public static String printPath(String ans, int r, int c) {
        if(r==1 && c==1) {
            System.out.println(ans);
            return ans;
        }
        if(r>1) {
            printPath(ans+'D',r-1,c);
        }
        if(c>1) {
            printPath(ans+'R',r,c-1);
        }
        return ans;
    }

    public static int gridWays(int i, int j, int n, int m) { // T.C = O(2^n+m)
        // base case
        if(i==n-1 && j==m-1) { // condn for last cell
            return 1;
        } else if(i==n || j==m) { // bound cross condn
            return 0;
        }  

        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1+w2;
    }

    public static void main(String[] args) {
        // int n = 3, m = 3;
        // System.out.println(gridWays(0, 0, n, m));

        System.out.println(printPath("", 3, 3));        
    }

}
