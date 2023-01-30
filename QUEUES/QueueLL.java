package QUEUES;

public class QueueLL {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        //add
        public void add(int data) {
            Node newNode = new Node(data);
            if(head == null) { // 1st time 
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        //remove
        public int remove() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int front = head.data;

            //single element in LL
            if(tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        //peek
        public int peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1); 
        q.add(2); 
        q.add(3);

        while(!q.isEmpty()) { // 1 2 3 
            System.out.println(q.peek());
            q.remove();
        }
    }
}
