package Trie;

public class StartwithProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
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

    public static boolean startWith(String prefix) { // O(L)
        Node curr = root;
        for(int i=0; i<prefix.length(); i++) {
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx]; // update curr
        }
        return true; // agar ab tak koe false nhe aaya to true return hojaegae
    }
    public static void main(String[] args) {
        String words[] = {"apple", "app", "mango", "man", "woman"};
        String prefix1 = "app";
        String prefix2 = "moon";

        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        System.out.println(startWith(prefix1));
        System.out.println(startWith(prefix2));
    }
}
