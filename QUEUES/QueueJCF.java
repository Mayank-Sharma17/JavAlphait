package QUEUES;
import java.util.*;

public class QueueJCF {
    public static void main(String[] args) {
       // Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> q = new LinkedList<>(); // queue is a interface iska obj nahe bana sakte jo class iske implementation karege us class ke object banate hai 
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) { // 1 2 3
            System.out.println(q.peek());
            q.remove();
        }
    }
}
