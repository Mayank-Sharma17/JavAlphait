package GREEDY_ALG;

import java.util.*;

public class Chocolate {
    public static void main(String[] args) {
        //int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 }; // m-1
        Integer costHor[] = { 4, 1, 2 }; // n-1

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder()); // sort on the base of cost

        int h = 0, v = 0; // pointers
        int hp = 1, vp = 1; // pieces
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            // vertical cost < hor cost
            if (costVer[v] <= costHor[h]) {
                // horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else {
                // vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }
        while (h < costHor.length) { //for remaining pieces
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }
        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }
        System.out.println("min cost of cuts = " + cost);
    }
}
