import java.util.LinkedList;
public class JavaClctnFrmwrk {
    public static void main(String[] args) {
        // create 
        LinkedList<Integer> ll = new LinkedList<>();

        // add element
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        System.out.println(ll); // [0 1 2]

        // remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll); // [1]
    }
    
}
