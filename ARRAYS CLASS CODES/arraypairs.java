public class arraypairs {
    public static void printPairs(int numbers[]) {
        int tp = 0; // to calculate total no of pairs in an array = n(n-1)/2

        for (int i = 0; i < numbers.length; i++) {
            int curr = numbers[i]; // 2,4,6,8,10

            for (int j = i + 1; j < numbers.length; j++) {
                System.out.print("(" + curr + "," + numbers[j] + ")");

                tp++;
            }
            System.out.println();
        }
        System.out.println("total pairs in array =" + tp); // print total no. of pairs
    }

    public static void printSubarrays(int numbers[]) {
        int ts = 0; // total subarrays =n(n+1)/2

        for (int i = 0; i < numbers.length; i++) {
            int start = i;

            for (int j = i; j < numbers.length; j++) {
                int end = j;

                for (int k = start; k <= end; k++) { // print
                    System.out.print(numbers[k] + " ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total subarray = " + ts);
    }

    public static void maxSubarraySum(int numbers[]) { // BRUTE FORCE T.C(time complexity) = O(n^3)
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE; // stroting -infinity

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currSum = 0;

                for (int k = start; k <= end; k++) { // subarray Sum
                    currSum += numbers[k];
                }
                System.out.println(currSum);
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum =" + maxSum);
    }

    public static void maxSubarrayprefixsum(int numbers[]) { // PREFIX SUM T.C= O(n^2)
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        prefix[0] = numbers[0];
        // calculate prefix array
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum =" + maxSum);
    }

    public static void kadanes(int numbers[]) { // KADANES MAX SUBARRAY SUM T.C= O(n) impo*
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < numbers.length; i++) {
            cs = cs + numbers[i];

            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms); // jo bhe maximum hoga vo ms mae store hojaega
        }
        System.out.println("our maximum sub array sum is = " + ms);
    }

    public static void main(String args[]) {
        // int numbers[] = { 2, 4, 6, 8, 10 };
        // printPairs(numbers);
        // printSubarrays(numbers);

        // int numbers[] = { 1, -2, 6, -1, 3 };
        // maxSubarraySum(numbers);
        // maxSubarrayprefixsum(numbers);

        int numbers[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        kadanes(numbers);
    }
}
