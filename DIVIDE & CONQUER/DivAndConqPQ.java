public class DivAndConqPQ {
    public static String[] mergSort(String[] arr, int lo, int hi) {
        //base case
        if(lo == hi) {
            String[] A = {arr[lo]};
            return A;
        }
        //kaam
        int mid = lo+(hi-lo)/2;
        String[] arr1 = mergSort(arr, lo, mid);
        String[] arr2 = mergSort(arr, mid+1, hi);

        String[] arr3 = merge(arr1, arr2);
        return arr3;
    }

    static String[] merge(String[] arr1, String[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        String[] arr3 = new String[m+n];

        int idx = 0;
        int i = 0;
        int j = 0;

        while(i < m && j < n) {
            if(isAlphabeticallySmaller(arr1[i], arr2[j])) {
                arr3[idx] = arr1[i];
                i++;
                idx++;
            } else {
                arr3[idx] = arr2[j];
                j++;
                idx++;
            }
        }
        while(i < m) {
            arr3[idx] = arr1[i];
            i++;
            idx++;
        } 
        while(j < n) {
            arr3[idx] = arr2[j];
            j++;
            idx++;
        }
        return arr3; 
    }

    // return ture str1 appears before str2 in aphabetical order
    static boolean isAlphabeticallySmaller(String str1, String str2) {
        if(str1.compareTo(str2) < 0) {
            return true;
        }
        return false;
    }

    // Q2 Brute Force O(n^2) apprach return majority element
    public static int majorityElement(int nums[]) {
        int majoritycount = nums.length/2;

        for(int i=0; i < nums.length; i++) {
            int count = 0;
            for(int j=0; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    count += 1;
                }
            }
            if(count > majoritycount) {
                return nums[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // String[] arr = {"sun", "earth", "mars", "mercury"};
        // String[] a = mergSort(arr, 0, arr.length-1);

        // for(int i = 0; i < a.length; i++) {
        //     System.out.print(a[i]+" ");
        // }
            
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));  
    }
    
}
