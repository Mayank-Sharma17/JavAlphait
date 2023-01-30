package STACKS; // LIFO Data Structure Last in first out DS
import java.util.ArrayList; // stack using AL

public class Stack { // explicit stack

    static class Stacks{
        static ArrayList<Integer> list = new ArrayList<>(); // created AL

        public boolean isEmpty() { // return true or false if list is empty or not
            return list.size() == 0;
        }

        // push operation O(1)
        public void push(int data) {
            list.add(data);
        }

        // pop operation O(1)
        public int pop() {
            // corner case
            if(isEmpty()) {
                return -1; 
            }
            int top = list.get(list.size() - 1); // last index
            list.remove(list.size() -1);
            return top;
        }

        // peek operation O(1)
        public int peek() {
            // corner case
            if(isEmpty()) {
                return -1; 
            }
            return list.get(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        Stacks s = new Stacks();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
