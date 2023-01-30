package HASHING;
import java.util.*;

public class SubarrSumEqualtoK {
    public static void main(String[] args) { // O(n)
        int arr[] = {10,2,-2,-20,10}; // return no of subarrays whose sum is = to k
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        //        <sum , count>
        map.put(0,1); // intilializing map
        int sum = 0;
        int ans = 0;

        for(int j=0; j<arr.length; j++) {
            sum += arr[j]; // 0 10 12 10 -10 0
            if(map.containsKey(sum)) {
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }
}
