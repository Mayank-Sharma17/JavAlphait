package STACKS;
import java.util.Stack;

public class Simplifypath { // O(n) and SC O(1)
    static String simplify(String A) {
        Stack<String> st = new Stack<>(); // st to store file name
        String res = ""; // initialize with empty string
        res += "/";
        int len_A = A.length(); // string length of string A

        for (int i = 0; i < len_A; i++) {
            String dir = "";
            while (i < len_A && A.charAt(i) == '/')
                i++;
            while (i < len_A && A.charAt(i) != '/') {
                dir += A.charAt(i);
                i++;
            }
            if (dir.equals("..") == true) {
                if (!st.isEmpty())
                    st.pop();
            } 
            else if (dir.equals(".") == true)
                continue;
            else if (dir.length() != 0)
                st.push(dir);
        }
        Stack<String> st1 = new Stack<String>(); // temp stack contains the reverse of st
        while (!st.isEmpty()) {
            st1.push(st.pop());
        }
        while (!st1.isEmpty()) {
            if (st1.size() != 1)
                res += st1.pop() + "/";
            else
                res += st1.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String str = new String("/a/./b/../../c");
        String res = simplify(str);
        System.out.println(res);
    }
}
