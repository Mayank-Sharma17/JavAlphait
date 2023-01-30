package QUEUES;

public class Queues {

    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front; // circular queue 

        Queue(int n) {
            arr = new int[n]; //  n is size of array
            size = n;
            rear = -1; // shuraat mae queue empty hai 
            front = -1; // initialize
        }

        // is empty 
        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return (rear+1)%size == front;
        }

        // add O(1)
        public void add(int data) {
            if(isFull()) { // rear == size-1 purane condn
                System.out.println("queue is full");
                return;
            }
           //rear = rear+1;
           if(front == -1) { // add 1st element
                front = 0;
           }
            rear = (rear+1)%size;
            arr[rear] = data;
        }
        
        // remove O(n) to make it O(1) we use circular queue
        public int remove() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            // int front = arr[0];
            // for(int i=0; i<rear; i++) {
            //     arr[i] = arr[i+1]; // ek step pheche shift karenge
            // }

            int result = arr[front];
            // last element ko agar delete kar rahe hai 
            if(rear == front) {
                rear = front = -1;
            } else {
                front = (front+1)%size;
            }
            //rear = rear-1;
            //return front;
            return result;
        }

        // peek O(1)
        public int peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            //return arr[0];
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(3); // n is arr ka size
        q.add(1); 
        q.add(2); 
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        
        while(!q.isEmpty()) { // 1 2 3 
            System.out.println(q.peek());
            q.remove();
        }
    }
}