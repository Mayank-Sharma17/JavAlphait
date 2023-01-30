package HASHING;
import java.util.*;
     
public class LargestSubarrwith0sum {
    public static void main(String[] args) { // O(n)
        int arr[] = {15,-2,2,-8,1,7,10,23}; // given array 
        // brute force - nested loop T.C o(N^2)

        HashMap<Integer, Integer> map = new HashMap<>(); // stroing (sum, idx)
        int sum = 0;
        int len = 0;

        for(int j=0; j<arr.length; j++) {
            sum += arr[j]; // adding our first sum
            if(map.containsKey(sum)) {
                len = Math.max(len, j - map.get(sum)); // if we found our sum already exist in the map then compare the length with (j-i)
            } else {
                map.put(sum, j); // if you dryrun this code from here we are storing our (sum, idx)
            }
        }

        System.out.println("Max subarray with sum 0 = "+len);
    }
}
