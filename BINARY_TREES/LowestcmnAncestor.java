package BINARY_TREES;

import java.util.ArrayList;

public class LowestcmnAncestor {
    static class Node {
        int data;
        Node left, right;

        Node(int data) { // constructor
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }

        path.add(root);
        if(root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path); // for left and right subtree
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    // Approach 1
    public static Node lca(Node root, int n1, int n2) { // time and space complexity is O(N)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1); //root - n1
        getPath(root, n2, path2); // roott - n2


        // last common ancestor
        int i = 0;
        for(; i<path1.size() && i<path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }
        //last equal node
        Node lca = path1.get(i-1);
        return lca;
    }

    // Approach 2
    public static Node lca2(Node root, int n1, int n2) { // TC = O(N) and SC = O(1)
        // if(root == null) {
        //     return null;
        // }
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // if leftLca give valid value and rightLca - null vice versa
        if(rightLca == null) {
            return leftLca;
        }
        if(leftLca == null) {
            return rightLca;
        }

        return root;
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

            int n1=4, n2=5;
            System.out.println(lca(root, n1, n2).data);
    }
}
