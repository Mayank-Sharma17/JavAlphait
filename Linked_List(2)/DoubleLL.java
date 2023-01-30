public class DoubleLL {

    public class Node { // Node class
        int data; // poerties
        Node next;
        Node prev;

        public Node(int data) { // constructor
            this.data = data; // initializing Node
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head; // properties
    public static Node tail;
    public int size;

    // add first in doubly ll
    public void addFirst(int data) { // O(1)
        // step 1 create a node
        Node newNode = new Node(data);
        size++;
        // base case
        if (head == null) { // LL is empty
            head = tail = newNode;
            return;
        }

        newNode.next = head; // link
        head.prev = newNode;
        head = newNode;
    }

    // remove firt dll
    public int removeFirst() {
        if(head == null) {
            System.out.println("dll is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data; // phele uska data store karalo
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    // print dll
    public void print() { // O(n)

        Node temp = head; // temp node - head

        while (temp != null) { // head ke value ko temp mae assign karna then temp pr loop chalana
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Reverse a Doubly Linked List
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2); // 1<->2<->3<->null
        dll.addFirst(1);

        dll.print();
        System.out.println(dll.size);

        dll.removeFirst();
        dll.print();
        System.out.println(dll.size);

        dll.reverse();
        dll.print();
        
    }
}
