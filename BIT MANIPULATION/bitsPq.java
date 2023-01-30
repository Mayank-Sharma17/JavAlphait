public class bitsPq {
    public static void main(String args[]) {
        // int x = 3, y = 4;
        // System.out.println("Before swap x= " + x + " and y= " + y);
        // // Swap using XOR
        // x = x ^ y;
        // y = x ^ y;
        // x = x ^ y;
        // System.out.println("After swap x= " + x + " and y= " + y);

        // int x = 6;
        // System.out.println(x + " + " + 1 + " is " + -~x );
        // x = -4;
        // System.out.println(x + " + " + 1 + " is " + -~x );
        // x = 0;
        // System.out.println(x + " + " + 1 + " is " + -~x );

        // convert uppercase to lowercase using bits
        for(char ch = 'A'; ch <= 'z'; ch++) {
            System.out.println((char) (ch | ' ')); // prints abcdefghijklmnopqrstuvwxyz
        }
    }
}
