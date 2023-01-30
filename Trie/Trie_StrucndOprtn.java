package Trie;

public class Trie_StrucndOprtn {
    static class Node {
        Node children[] = new Node[26]; // 'a' - 'z'
        boolean eow = false;// initialize end of word with false
        
        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }
    public static Node root = new Node(); // root node is diff it only carry info of child not any data

    // insert in Trie
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

    // search in Trie
    public static boolean search(String key) {
        Node curr = root;
        for(int level=0; level<key.length(); level++) {
            int idx = key.charAt(level)-'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
    
 //---------------------------WORD BREK PROBLEM------------------------------------------------
    public static boolean wordBreak(String Key) {
        if(Key.length() == 0) {
            return true;
        }
        for(int i=1; i<=Key.length(); i++) {
            if(search(Key.substring(0, i)) && wordBreak(Key.substring(i))) {
                // .substring funciton mar lastidx exclusive hai              
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        /* String words[] = {"the", "a", "there", "their", "any", "thee"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("thee"));
        System.out.println(search("thor")); */

        String arr[] = {"i", "like", "sam", "samsung",  "mobile", "ice"};
        for(int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }
        String Key = "ilikesamsung";
        System.out.println(wordBreak(Key));
    }
}
