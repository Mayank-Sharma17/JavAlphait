
public class FindSubsets {
    public static void findSubsets(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
                return;
            } else {
                System.out.println(ans);
            }
            return;
        }

        // recursion
        // choice yes
        findSubsets(str, ans + str.charAt(i), i + 1);
        // choice no
        findSubsets(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str, "", 0);
    }

}
// Time complexity = O(n*2^n) -- because total subsets = 2^no of ele=n for i ele > n time 
// Space complexity = O(n)