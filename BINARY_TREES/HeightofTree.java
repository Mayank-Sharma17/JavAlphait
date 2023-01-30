package BINARY_TREES; // TC for all methods is O(N)
//import java.util.*;

public class HeightofTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) { // constructor
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if(root == null) {
            return 0; //ht = 0
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1; // +1 for parent height
    }

    public static int count(Node root) {
        if(root == null) {
            return 0;
        }
        int leftcount = count(root.left);
        int rightcount = count(root.right);

        return leftcount + rightcount + 1; // 7 nodes
    }

    public static int sum(Node root) {
        if(root == null) {
            return 0;
        }
        int leftsum = sum(root.left);
        int rightsum = sum(root.right);

        return leftsum + rightsum + root.data; // sum of nodes is 28
    }
    public static void main(String[] args) {
                //      1
                //    /   \
                //   2     3  tree defined
                //  / \   / \
                // 4   5 6   7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        System.out.println(sum(root));
    }
}
