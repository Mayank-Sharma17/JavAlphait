
import java.util.ArrayList;
import java.util.Collections;

public class ALpractice {
    public static boolean ifMonotonic(ArrayList<Integer> nums) { // monotonic AL

        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1))
                inc = false;
            if (nums.get(i) < nums.get(i + 1))
                dec = false;
        }
        return inc || dec;
    }

    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) { // find lonely numbers

        Collections.sort(nums); // [5 6 8 10]

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 1; i < nums.size() - 1; i++) {

            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
                ans.add(nums.get(i));
            }
        }

        if (nums.size() == 1) {
            ans.add(nums.get(0));
        }

        if (nums.size() > 1) {
            if (nums.get(0) + 1 < nums.get(1)) {
                ans.add(nums.get(0));
            }
            if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
                ans.add(nums.get(nums.size() - 1));
            }
        }
        return ans;
    }

    public static int mostFrequent(ArrayList<Integer> nums, int key) {
        int result[] = new int[1000];

        for(int i=0; i<nums.size()-1; i++) {
            if(nums.get(i) == key) {
                result[nums.get(i+1)-1]++;
            }
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0; i<1000; i++) { // iterating in {100,100}
            if(result[i] > max) {
                max = result[i];
                ans = i+1;
            }
        }
        return ans;
    }

    public static  ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        for(int i=2; i<=n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            for(Integer e:ans) {
                if(2*e <= n) temp.add(e*2);
            }
            for(Integer e:ans) {
                if(2*e-1 <= n) temp.add(e*2-1);
            }
            ans = temp;
        }
        return ans;
        
    }

    public static void main(String[] args) {
        // ArrayList<Integer> nums = new ArrayList<>();
        // // nums = [1 2 2 3]
        // nums.add(1);
        // nums.add(100);
        // nums.add(200);
        // nums.add(1);
        // nums.add(100);
        // int key = 1;

        System.out.println(beautifulArray(4));

    }

}
