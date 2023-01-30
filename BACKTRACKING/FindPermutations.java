
public class FindPermutations {
    public static void findPermutations(String str, String ans) {
        // BC
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        // Recursion
        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            // "abcde" = "ab"+"de" = "abde"
           String Newstr = str.substring(0,i) + str.substring(i+1); // i vala char choice 
           findPermutations(Newstr, ans+curr);
        }
    }
    public static void main(String[] args) {
        String str = "abc"; 
        findPermutations(str, "");      
    }
}
// 6 permutations for string abc
// used enumeration
// time comp. = for 1 permutaion - n time + total ways n! = O(n*n!) 
