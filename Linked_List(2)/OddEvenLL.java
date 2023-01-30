public class OddEvenLL {

    Node head;

    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    void segregateEvenOdd() {
        Node end = head;
        Node prev = null;
        Node curr = head;

        while(end.next != null) // Get pointer to last node
        end = end.next;

        Node new_end = end;

        //consider all odd nodes before getting first even node
        while(curr.data %2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        // do following steps only if there is an even node
        if(curr.data %2 == 0) {
            head = curr;
        
            // now curr points to first even node
            while(curr != end) {
                if(curr.data %2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    //break the link b/w prev and curr
                    prev.next = curr.next;

                    //make nect of curr as null
                    curr.next = null;

                    //move curr to end
                    new_end.next = curr;

                    //make curr as new end of list
                    new_end = curr;

                    //update curr pointer
                    curr = prev.next;
                }
            }    
        } 

        // we have to set prev before executing rest of this code
        else prev = curr;
        if(new_end != end && end.data %2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }    
        
    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        OddEvenLL llist = new OddEvenLL();

        llist.push(6);
        llist.push(1);
        llist.push(4);
        llist.push(5);
        llist.push(10);
        llist.push(12);
        llist.push(8);

        System.out.println("Original linked list");
        llist.printList();

        llist.segregateEvenOdd();

        System.out.println("Modified linked list");
        llist.printList();
    }
    
}
