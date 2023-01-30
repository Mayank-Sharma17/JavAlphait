public class bitsQues {
    public static int clearIBits(int n, int i) {
        int bitmask = (~0)<<i;
        return n & bitmask; // clear karna ho ya hatana ho to & leloo
    }

    public static int clearRangeofBits(int n, int i, int j) {
        int a = (~0)<<(j+1);
        int b = (1 <<i) - 1;
        int bitmask = a|b; // 11110000011 like this is our bitmask
        return n & bitmask;
    }

    public static boolean isPowerofTow(int n) {
        return (n & (n-1)) == 0;
    }

    public static int countSetBits(int n) { // T.C = O(n), max set bits n-(logn+1)
        int count = 0;
        while(n > 0) {
            if((n & 1) != 0) { // check out LSB
                count ++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int FastExpo(int a, int n) {
        int ans = 1;          
                //<----------------------------
        while(n > 0) {         //             -
            if((n & 1) != 0) { // check LSB   -
                ans = ans * a; //             -
            }                  //             -
            a = a*a;           //             -   
            n = n >> 1; // jabtak n>0 naho>---- 
        }
        return ans;
    }
    public static void main(String args[]) {
       System.out.println(FastExpo(5, 3));        
    }   
}
