package HASHING;

import java.util.*;

public class LinkednTreehm {
    public static void main(String[] args) {
        // create Linked Hash Map- maintains the order of insertion
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);
        lhm.put("Nepal", 5);
        System.out.println(lhm);
        // internally it is implemented by using Doubly Linked List Data structure

        // create Tree Map- gives sorted map in ascending order on the basis of keys
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);
        tm.put("Nepal", 5);
        System.out.println(tm);
        // A Red-Black tree (self balancing Tree) based NavigableMap implementation. The
        // map is sorted
        // according to the natural ordering of its keys, or by a Comparator provided at
        // map creation time, depending on which constructor is used.
        // TC O(logn) for function- containsKey, put, remove, get
    }
}
