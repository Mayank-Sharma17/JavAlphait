package GREEDY_ALG;

import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;

        double ratio[][] = new double[val.length][2]; // oth col-idx; 1st col-ratio
        for(int i=0; i<val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i]; //ratio
        }

        // ascending order mae hua a sorting phele dece tha
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W; 
        int finalVal = 0;

        for(int i=ratio.length-1; i>=0; i--) {
            int idx = (int)ratio[i][0];

            if(capacity >= weight[idx]) {
                //include full iteam
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                //include fractional iteam
                finalVal += (ratio[i][1]*capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("final value = " + finalVal);
    }
}
