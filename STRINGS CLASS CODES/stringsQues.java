public class stringsQues {
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) { // O(n)
            int n = str.length();
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                // not a palindrome
                return false;
            }
        }
        return true;
    }

    public static float getShortestPath(String path) { // O(n)
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            // South
            if (dir == 'S') {
                y--;
            }
            // North
            else if (dir == 'N') {
                y++;
            }
            // West
            else if (dir == 'W') {
                x--;
            }
            // East
            else {
                x++;
            }
        }
        int X2 = x * x;
        int Y2 = y * y;
        return (float) Math.sqrt(X2 + Y2);
    }

    public static String SubString(String Str, int si, int ei) {
        String subStr = "";
        for(int i=si; i<ei; i++) {
            subStr += Str.charAt(i);
        }
        return subStr;
    }
    public static void main(String args[]) {
        // // check if a string is a plindrome
        // String str = "racecar";
        // System.out.println(isPalindrome(str));

        // String path = "WNEENESENNN";
        // System.out.println(getShortestPath(path));

        // String functions compare
        // String S1 = "Tom";
        // String S2 = "Tom";
        // String S3 = new String("Tom");

        // if (S1 == S2) {
        //     System.out.println("Strings are equal"); // this is the output
        // } else {
        //     System.out.println("Strings are not equal");
        // }

        // // if (S1 == S3) {
        // //     System.out.println("Strings are equal");
        // // } else {
        // //     System.out.println("Strings are not equal"); // this is the output
        // // }

        // if (S1.equals(S3)) {
        //     System.out.println("Strings are equal"); // this is the output '.equals' return boolean type value always
        //                                                 // use this to comapre
        // } else {
        //     System.out.println("Strings are not equal");
        // }

        String str = "HelloWorld";
        System.out.println(SubString(str, 0, 5));
        System.out.println(str.substring(0,5)); // Java inbuilt substring 
    }
}
