package STACKS;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i); // store brackets

            //opening
            if(ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                //closing phele check kro stack khale to nahe agr hai to invaild hai ex ')))'
                if(s.isEmpty()) {
                    return false;
                }
                
                //now check pair
                if((s.peek() == '(' && ch == ')')
                 ||(s.peek() == '{' && ch == '}')
                 ||(s.peek() == '[' && ch == ']')) {

                    s.pop();
                } else {
                    return false; //no pair form
                }
            }
        }
        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        String str = "))))"; // ture
        System.out.println(isValid(str));
    }
}
