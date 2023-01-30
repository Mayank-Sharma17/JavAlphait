package Trie;

public class Prefixproblem {
    static class Node {
        Node[] children = new Node[26]; //children node array
        boolean eow = false;
        int freq;
        public Node() { // constructor
            for(int i=0; i<children.length; i++) {
                // initialize children node with null
                children[i] = null;
            }
            freq = 1;
        }
    }
    public static Node root = new Node();

    public static void insert(String word) { // create a trie
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            // find index
            int idx = word.charAt(i)-'a'; // index of that word in the string
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node(); // add new node agar curr children arr pr kuch nahe hai to
            } else {
                curr.children[idx].freq++; // nahe to freq to increase krdo by one of that char
            }
            curr = curr.children[idx]; // curr ko update krdo
        }
        curr.eow = true;
    }

    public static void findPrefix(Node root, String ans) {
        if(root == null) { // Base case
            return;
        }
        if(root.freq == 1) { // Base case
            System.out.print(ans+" ");
            return;
        }

        for(int i=0; i<root.children.length; i++) { // root.children.length = 26
            if(root.children[i] != null) {
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }
    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        for(int i=0; i<arr.length; i++) {
            insert(arr[i]); // creating a trie
        }
        root.freq = -1; // intializing freq
        findPrefix(root, " "); // empty string 
    }
}
