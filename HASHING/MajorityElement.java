package HASHING;
import java.util.*;

public class MajorityElement {
    public static void main(String[] args) { // O
        int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {           
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);            
        }

        // Set<Integer> KeySet = map.keySet();
        for (Integer key : map.keySet()) { // ese bhe like sakte hai keySet function ko adv loop mae hee call kreke key var mae store kara liya
            if(map.get(key) > nums.length/3) {
                System.out.println(key);
            }
        }
    }
}
