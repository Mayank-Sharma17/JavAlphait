package QUEUES;

import java.util.*;

public class DoublendedQ { // double ended queue
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2); // [2, 1]
        // deque.removeFirst();
        deque.addLast(3);// 2 1 3
        deque.addLast(4);// 2 1 3 4

        System.out.println(deque);
        System.out.println("first element = " + deque.getFirst());
    }
}
