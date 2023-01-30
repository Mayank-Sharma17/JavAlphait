public class ReverseLL {

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

    public void addFirst(int data) { // O(1)
        Node newNode = new Node(data);

        if (head == null) { // LL is empty
            head = tail = newNode;
            return;
        }
        
        newNode.next = head; // link
        head = newNode;
    }

    public void reverse() { // o(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev; // update head
    }

    public void deleteNthFromEnd(int n) { // O(n)
        // calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        
        if(n == sz) {
            head = head.next; // remove first
            return;
        }
        
        // sz-n
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node findMid(Node head) { // helper
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // +1 jump
            fast = fast.next.next; // +2 jump
        }
        return slow; // slow is my mid Node
    }

    public boolean checkPalindrome() { // T.C = O(n), S.C = O(1)
        if(head == null || head.next == null) {
            return true;
        }
        // step-1 find mid
        Node midNode = findMid(head);

        // reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // right half head
        Node left = head;

        // step-3 check left half & right half
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next; // update
            right = right.next;
        }
        return true;
    }
    public void print() { // O(n)

        Node temp = head; // temp node - head

        while (temp != null) { // head ke value ko temp mae assign karna then temp pr loop chalana
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        ReverseLL ll = new ReverseLL();
        //ll.addFirst(5);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(2);
        ll.addFirst(1);

        ll.print();
        //ll.deleteNthFromEnd(3);
        System.out.println(ll.checkPalindrome());
        //ll.print();   
             
    } 
}
