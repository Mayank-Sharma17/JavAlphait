package Trie;

public class CountUniqSubstr {
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

    public static int countNodes(Node root) {
        if(root == null) {
            return 0; // count = 0
        }
        int count = 0;
        for(int i=0; i<26; i++) {
            if(root.children[i] != null) { // if child exist
                count += countNodes(root.children[i]);
            }
        }
        return count+1; // plus one for empty string
    }
    public static void main(String[] args) {
        String str = "ababa";

        // suffic nikalenge fir insert kredege trie mae preffix tree jo baad mae sare unique preffix dedga
        for(int i=0; i<str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(countNodes(root));
    }
}
