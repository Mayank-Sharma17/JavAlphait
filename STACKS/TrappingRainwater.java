package STACKS;
import java.util.Stack;

public class TrappingRainwater {

    // TRAPPING RAINWATER and T.C of this code = O(n) and space complecity O(n)

    public static int maxWater(int height[]) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int ans = 0;

        for(int i=0; i<n; i++) {
            while((!stack.isEmpty()) && (height[stack.peek()] < height[i])) {
                int pop_height = height[stack.peek()];
                stack.pop();
                
                if(stack.isEmpty())
                    break;
                int distance = i-stack.peek() - 1;
                int min_height = Math.min(height[stack.peek()], height[i]) - pop_height;
                
                ans += distance*min_height;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String args[]) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Water trapped between the bars = " + maxWater(height));
    }

}
