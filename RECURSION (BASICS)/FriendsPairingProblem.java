
public class FriendsPairingProblem {
    public static int friendsPairing(int n) {
        if( n == 1 || n == 2) { // BC
            return n;
        }
        // // choice
        // // Single
        // int fnm1 = friendsPairing(n-1);
        // // Pair
        // int fnm2 = friendsPairing(n-2);

        // int pairways = (n-1) * fnm2;
        // int totalways = fnm1 + pairways;

        // return totalways;

        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }
    public static void main(String args[]) {
        System.out.println(friendsPairing(3));
    }
}
