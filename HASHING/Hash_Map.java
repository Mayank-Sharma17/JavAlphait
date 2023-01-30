package HASHING;
import java.util.HashMap;

public class Hash_Map {
    public static void main(String[] args) {
        // create Hash Map
        HashMap<String, Integer> hm = new HashMap<>();

        // insert in hm O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);

        // get value of key O(1)
        System.out.println(hm.get("India")); // 100
        System.out.println(hm.get("Bhutan")); // null

        // conatins key func O(1)
        System.out.println(hm.containsKey("India")); // true
        System.out.println(hm.containsKey("Bhutan")); // false

        // remove pair in hm O(1)
        System.out.println(hm.remove("China"));
        System.out.println(hm); // {US=50, India=100} pair of China key is removed 

        // size of hm 
        System.out.println(hm.size()); // 2

        // clear function it used to empty our hash map
        hm.clear();
        System.out.println(hm.isEmpty()); // true
    }
}
