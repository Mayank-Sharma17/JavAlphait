package STACKS;
import java.util.Stack;

public class NextgreaterEle {
    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3}; // given arr
        Stack<Integer> s = new Stack<>(); // store prev high index
        int nxtGreater[] = new int[arr.length]; // store the next greater element 

        for(int i = arr.length-1; i>=0; i--) { // backward traverse
            // 1 while loop
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop(); // sab tak chote ele aare hai pop krte raho
            }

            // 2 if-else loop
            if(s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }

            // 3 push in s 
            s.push(i);
        }
        for(int i=0; i<nxtGreater.length; i++) {
            System.out.print(nxtGreater[i] + " ");
        }
        System.out.println();   
    }
}
