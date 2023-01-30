package BST;
import java.util.*;

public class RoottoLeafpath {
    static class Node {
        int data;
        Node left;
        Node right;
         
        Node(int data) {
            this.data = data;
        }
    }

    public  static Node insert(Node root, int val) { // time complexity is O(H) height of BST
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(root.data > val) { // insert in left Sub Tree
            root.left = insert(root.left, val);
        } else { // insert in right sub tree
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);

        path.remove(path.size()-1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("null");
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }
        if(min != null && root.data <= min.data) {
            return false;
        }
        if(max != null && root.data >= max.data) {
            return false;
        }
        
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 6, 10, 11, 14};
         Node root = null; // initialize root

        for(int i=0; i<values.length; i++) { // insert values in BST
            root = insert(root, values[i]);
        }
        // print our BST
        inorder(root);
        System.out.println();

        //printRoot2Leaf(root, new ArrayList<>());
        if(isValidBST(root, null, null)) {
            System.out.println("valid");
        } else {
            System.out.println("not valid");
        }
    }
}
