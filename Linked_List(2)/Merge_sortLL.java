
public class Merge_sortLL {

    public static class Node { // Node class
        int data; // poerties
        Node next;

        public Node(int data) { // constructor
            this.data = data; // initializing Node
            this.next = null;
        }
    }
    public Node head; // properties
    public Node tail;

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
    public static void main(String[] args) {
        Merge_sortLL ll = new Merge_sortLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        // [5 4 3 2 1]

        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print(); 
        
    }

}
