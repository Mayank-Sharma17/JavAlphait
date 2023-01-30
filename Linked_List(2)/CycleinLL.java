// Floyd's Cycle finding Algorithm (CFA)
public class CycleinLL { // detecting if cycle is present in LL or not

    public static Node head; // properties
    public static Node tail;

    public static class Node { // Node class
        int data; // poerties
        Node next;

        public Node(int data) { // constructor
            this.data = data; // initializing Node
            this.next = null;
        }
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next;

            if(slow == fast) {
                return true; // cycle exists
            }
        }
        return false; // cycle doesn't exists
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        //boolean cycle = false; ---
        while(fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next;

            if(slow == fast) {
                //cycle = true; ---
                break;
            }
        }
        // if(cycle = false) { ---
        //     return;
        // }                   ---

        // find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle -> last.next = null
        prev.next = null;
    }
    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        // 1->2->3->2
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }
    
}
