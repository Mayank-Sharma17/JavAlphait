public class ZigZagLL {

    public static class Node { // Node class
        int data; // poerties
        Node next;

        public Node(int data) { // constructor
            this.data = data; // initializing Node
            this.next = null;
        }
    }
    public static Node head; // properties
    public static Node tail;

    public void addFirst(int data) { // O(1)
        // step 1 create a node
        Node newNode = new Node(data);
    
        // base case
        if (head == null) { // LL is empty
            head = tail = newNode;
            return;
        }
        // step 2
        newNode.next = head; // link
        // step 3
        head = newNode;
    }

    public void print() { // O(n)

        Node temp = head; // temp node - head

        while (temp != null) { // head ke value ko temp mae assign karna then temp pr loop chalana
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void ZigZag() {
        // find mid
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow; // jaha slow rukega vo mid node hojaega

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null; // to break in 2 parts
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR; // temp var

        // alternate merging
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
    public static void main(String[] args) {
        ZigZagLL ll = new ZigZagLL();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        
        ll.print();
        ll.ZigZag();
        ll.print();
    }
}