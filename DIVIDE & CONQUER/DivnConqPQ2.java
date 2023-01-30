public class DivnConqPQ2 {
    private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for(int i=lo; i<=hi; i++) {
            if(nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private static int majorityElementRec(int[] nums, int lo, int hi) { // O(nlogn)
        // base case
        if(lo == hi) {
            return nums[lo];
        }
        // recurse on left and right halves of the slice
        int mid = lo+(hi-lo)/2;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if new halves agree on the majority return it.
        if(left == right) {
            return left;
        }

        // otherwise count each element and return the "winner"
        int leftcount = countInRange(nums, left, lo, hi);
        int rightcount = countInRange(nums, right, lo, hi);

        return leftcount > rightcount ? left : right;
    }

    public static int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));        
    }
}
