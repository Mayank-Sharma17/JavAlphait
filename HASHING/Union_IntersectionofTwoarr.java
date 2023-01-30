package HASHING;
import java.util.*;

public class Union_IntersectionofTwoarr {
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        HashSet<Integer> set = new HashSet<>();
        // union O(n+m)
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.println("union of 2 arrays is = " + set.size());

        // intersection
        set.clear();
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        int count = 0;
        for(int i=0; i<arr2.length; i++) {
            if(set.contains(arr2[i])) { // unique element
                count++; 
                set.remove(arr2[i]); // remove that elem from the set 
            }             
        }
        System.out.println("intersection is = " + count);
    }
}
