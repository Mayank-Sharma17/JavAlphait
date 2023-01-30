package STACKS;
import java.util.Stack;

public class MaxAreainHistogram {

    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //next smaller right O(n)
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = arr.length; //n=6
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //next smaller left O(n)
        s = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = arr.length; //n=6
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //curr area width = j-i-1 = nrs[i] - nsl[i] - 1 O(n)
        for(int i=0; i<arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height*width;

            //compare
            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println("max area in histogram = " + maxArea);
    }
    public static void main(String[] args) {
        int arr[] = {2,4};
        maxArea(arr); // ans = 10
    }
}
