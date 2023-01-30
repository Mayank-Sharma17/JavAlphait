package BST;

public class BuildBst { 
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

    public static boolean Search(Node root, int key) { // O(H) search key in BST
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data > key) {
            return Search(root.left, key);
        } else {
            return Search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        } else if(root.data > val) {
            root.left = delete(root.left, val);
        } else { // Voila case xd
            //case 1 - single node
            if(root.left == null && root.right == null) {
                return null;
            }

            //case 2 - single child
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            //case 3 - both children
            // find IS - inorder successor - left most node in right subtree of BST
            Node IS = findInorderSuccessor(root.right); 
            //replace val
            root.data = IS.data;

            root.right = delete(root.right, IS.data); // right pointer undated after RST update
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) { // root not null hoaga vahe isme aarga
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null; // initialize root

        for(int i=0; i<values.length; i++) { // insert values in BST
            root = insert(root, values[i]);
        }
        // print our BST
        inorder(root);
        System.out.println();

        // if(Search(root, 1)) {
        //     System.out.println("key found");
        // } else {
        //     System.out.println("key not found");
        // }

        root = delete(root, 1);
        System.out.println();
        inorder(root);
    }
}