package STACKS;
import java.util.Stack;

public class PalindromeLL { // time and space compelxity is O(n)

    class Node {
        int data;
        Node ptr;

        Node(int d) {
            ptr = null;
            data = d;
        }
    }

    public static boolean isPalindrome(Node head) {
        Node slow = head;
        boolean ispalin = true;
        Stack<Integer> stack = new Stack<Integer>();

        while(slow != null) {
            stack.push(slow.data);
            slow = slow.ptr;
        }
        while(head != null) {
            int i = stack.pop();
            if(head.data == i) {
                ispalin = true;
            } else {
                ispalin = false;
            }
            head = head.ptr;
        }
        return ispalin;
    }
    public static void main(String[] args) {
        PalindromeLL plain = new PalindromeLL(); // instance of object of enclosing class
        
        Node one = plain.new Node(1); // create an instance of inner class that is connected with an instance of enclosing PalindromeLL class
        Node two = plain.new Node(2);        
        Node three = plain.new Node(3);        
        Node four = plain.new Node(4);        
        Node five = plain.new Node(3);        
        Node six = plain.new Node(2);        
        Node seven = plain.new Node(1);  
        
        one.ptr = two;
        two.ptr = three;
        three.ptr = four;
        four.ptr = five;
        five.ptr = six;
        six.ptr = seven;

        boolean condition = isPalindrome(one);
        System.out.println("Palindrom: " + condition);

    }
}
