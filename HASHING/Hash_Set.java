package HASHING;
import java.util.*;

public class Hash_Set { // no duplicates, unordered, null is allowed
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(); // implemented using HashMap and all operations TC O(N)
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);
        System.out.println(set);

        set.remove(2);
        System.out.println(set);


        LinkedHashSet<String> lhs = new LinkedHashSet<>(); // ordered isig DLL implemented using LHM
        lhs.add("Delhi");
        lhs.add("Mumbai"); 
        lhs.add("Noida");
        System.out.println(lhs); // same insertion order mae print hoga 

        TreeSet<String> ts = new TreeSet<>(); // implemented using TreeMap Red Black Tree Self balancing 
        ts.add("Delhi");
        ts.add("Noida"); 
        ts.add("Mumbai");
        System.out.println(ts); // sorted set in ascending order
    }
}
