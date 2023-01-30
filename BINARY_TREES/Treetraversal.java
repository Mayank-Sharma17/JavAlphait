package BINARY_TREES; // sbke time complexity O(N) hai 
import java.util.*;

import java.util.LinkedList;

public class Treetraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int data) { // constructor
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree { 
        static int idx = -1;
        public Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public void preorder(Node root) {// preorder traversal root->leftsubtree->rightsubtree
            if(root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public void inorder(Node root) { // inorder traversal leftsubtree->root->rightsubtree
            if(root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public void postorder(Node root) { // postorder traversal leftsubtree->rightsubtree->root 
            if(root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        //level order traversal
        public void levelorder(Node root) {
            if(root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null); // added 1|N|--

            while(!q.isEmpty()) {
                Node currNode = q.remove();

                if(currNode == null) {
                    System.out.println(); // next line print
                    if(q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if(currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        tree.levelorder(root); 
    }
}