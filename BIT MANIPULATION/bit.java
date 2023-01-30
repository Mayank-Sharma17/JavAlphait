public class bit {
    public static void OddorEven(int n) {
        int bitmask = 1;
        if((n & bitmask) == 0) {
            // even no.
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitmask = 1<<i;
        if((n & bitmask) == 0) {
            return 0;
        }else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitmask = 1<<i;
        return n | bitmask;
    }

    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1<<i);
        return n & bitmask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // if(newBit == 0) {
        //     return clearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }

        n = clearIthBit(n, i);
        int bitmask = newBit << i;
        return n | bitmask;
    }
    public static void main(String args[]) {
       // OddorEven(6);
       System.out.println(updateIthBit(10, 1, 0));
    }
}
