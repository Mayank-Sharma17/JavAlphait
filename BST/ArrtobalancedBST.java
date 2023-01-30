package BST;
import java.util.*;

public class ArrtobalancedBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node createBST(int arr[], int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST2(ArrayList<Integer> inorder, int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST2(inorder, st, mid-1);
        root.right = createBST2(inorder, mid+1, end);
        
        return root;
    }

    public static Node balanceBST(Node root) { // O(N)
        //inorder seq O(n)
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        //sorted inorder -> balanced BST O(n)
        root = createBST2(inorder, 0, inorder.size()-1);

        return root;
    }
    public static void main(String[] args) {
        // int arr[] = {3,5,6,8,10,11,12}; // sorted arr asc

        // Node root = createBST(arr, 0, arr.length-1);
        // preorder(root);


                /*
                     8
                   /   \
                  6     10
                 /       \
                5         11 
               /           \
              3             12
            given BST
         */
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        /*
                     8
                   /   \
                  5     11
                 / \    / \
                3   6  10 12   
            expected BST
         */

         root = balanceBST(root);
         preorder(root);
    }
}
