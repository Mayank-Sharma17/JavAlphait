package STACKS;
import java.util.Stack;

public class StockSpan {

    public static void stockSpan(int Stocks[], int span[]) {
        Stack<Integer> s = new Stack<>(); // in stack we store index of previous highs
        span[0] = 1;
        s.push(0);

        //for each day span
        for(int i=1; i<Stocks.length; i++) {
            int currPrice = Stocks[i];
            while(!s.isEmpty() && currPrice > Stocks[s.peek()]) {
                s.pop(); // chote valo ko nikalte jaenge
            }

            if(s.isEmpty()) { // check krte hai ke chote vale element nikalte nikalte kahe stack empty to nahe hoagaya
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int Stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[Stocks.length];

        stockSpan(Stocks, span);

        for(int i=0; i<Stocks.length; i++) {
            System.out.println(span[i] + " ");
        }
    }
}
