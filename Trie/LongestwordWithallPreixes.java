package Trie;

public class LongestwordWithallPreixes {
    public static class Node {
        Node[] children = new Node[26];
        boolean eow;
        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word) {
        Node curr = root;
        for(int level=0; level<word.length(); level++) { // O(L) length of word/string
            int idx = word.charAt(level)-'a';
            if(curr.children[idx] == null) { // create new Node
                curr.children[idx] =new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // last char of the word waha T
    }

    public static String ans = " ";
    public static void longestWord(Node root, StringBuilder temp) {
        if(root == null) {
            return;
        }
        for(int i=0; i<26; i++) { // a b c d...... if lexicography larger reverrse loop i=25 i>=0 i-- ans = apply
            if(root.children[i] != null && root.children[i].eow == true) {
                char ch = (char)(i+'a'); // char find krdiya
                temp.append(ch); // temp string mae add krdiya
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                //backtrack
                temp.deleteCharAt(temp.length()-1); // last idx pr jo char hai
            } 
        }
    }
    public static void main(String[] args) {
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans); // ans = apple
    }
}
