
public class LLBasicFunctions {

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
    public int size;

    public void addFirst(int data) { // O(1)
        // step 1 create a node
        Node newNode = new Node(data);
        size++;
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

    public void addLast(int data) { // O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() { // O(n)

        Node temp = head; // temp node - head

        while (temp != null) { // head ke value ko temp mae assign karna then temp pr loop chalana
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) { // O(n)
        if (idx == 0) { // base case
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // i = idx-1; temp->prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev: i=size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key) { // O(n) iterative search
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) { // key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        // key not found
        return -1;
    }

    public int recSearch(int key) { // time and space comp O(n) because of helper function
        return helper(head, key);
    }
    public int helper(Node head, int key) {
        if(head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        }
        
        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }
        return idx+1;
    }

    public Node mergeSort(Node head) {
        // base case
        if(head == null || head.next == null) {
            return head;
        }

        //find mid 
        Node mid = getMid(head);

        //left and right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid node
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public static void main(String args[]) {
        LLBasicFunctions ll = new LLBasicFunctions();

        ll.addFirst(4);
        ll.addFirst(5);
        ll.addLast(3); // out 1->2->3->4->5->null
        ll.addLast(2);
        ll.addLast(1);

        // ll.add(1, 0);
        // ll.removeFirst();
        // ll.removeLast();

        ll.print();
        System.out.println(ll.size);

        System.out.println(ll.recSearch(3));

    }
}
