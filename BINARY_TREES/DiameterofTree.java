package BINARY_TREES;

public class DiameterofTree {
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

    // Approach 1 O(n^2) using height function
    public static int diameter(Node root) {
        if(root == null) {
            return 0; // dia = 0
        }

        int leftDiam = diameter(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter(root.right);
        int rightHt = height(root.right);

        int selfDiam = leftHt + rightHt + 1;
        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

    // Approach 2 O(n) 2 calls for dia and ht
    static class Info {
        int diam, ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        } 
    }

    public static Info diameterO(Node root) {
        if(root == null) { // base case
            return new Info(0, 0); // diam and ht = 
        }
        Info leftInfo = diameterO(root.left);
        Info rightInfo = diameterO(root.right); //contains info of diam and ht both

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
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

                System.out.println(diameterO(root).diam); // object call
        
    }
}
