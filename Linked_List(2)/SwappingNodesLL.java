
public class SwappingNodesLL {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    public void swapNodes(int x, int y) {
        if(x == y) 
        return;

        // search for x
        Node prevX = null, currX = head;
        while(currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }
        // search for y
        Node prevY = null, currY = head;
        while(currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // if x and y is not present
        if(currX == null && currY == null)
        return;

        if(prevX != null) // if x is not head of LL
        prevX.next = currY;
        else // make y the new head
        head = currY;

        if(prevY != null) // if y is not head of LL
        prevY.next = currX;
        else // make y the new head
        head = currX;

        // swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public void push(int new_data) {
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        head = new_Node;
    }

    public void printList() {
        Node tNode = head;
        while(tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
    }
    public static void main(String[] args) {
        SwappingNodesLL llist = new SwappingNodesLL();
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
        
        System.out.print("\n Linked List before swapping ");
        llist.printList();

        llist.swapNodes(4, 3);

        System.out.print("\n Linked List after swapping ");
        llist.printList();
    }
    
}
