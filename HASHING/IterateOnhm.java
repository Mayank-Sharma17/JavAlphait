package HASHING;
import java.util.*;

public class IterateOnhm {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        // we use set DS to iterate on Hash Map it will contains KeySet() function which give collections of keys set 
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        // Iterate
        for (String k : keys) { // special loop foreach loop google it used t iterate over arr or collections
            System.out.println("keys=" +k+ ",value=" +hm.get(k));
        }
    }
}
