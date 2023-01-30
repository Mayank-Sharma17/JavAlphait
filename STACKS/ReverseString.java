package STACKS;
import java.util.Stack;

public class ReverseString { // FAANG

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;

        while(idx < str.length()) {
            s.push(str.charAt(idx)); // stack mae jo bhe push kro jab bahar aata hai to reverse hojaega
            idx++; // update index
        }

        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String str = "Hello World";

        String result = reverseString(str);

        System.out.println(result);
    }
}
