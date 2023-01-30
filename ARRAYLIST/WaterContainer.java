import java.util.ArrayList;

public class WaterContainer {

    public static int StoreWater(ArrayList<Integer> height) { // 2 Pointer Approach O(n)
        int maxWater = 0;
        int lp = 0; // left pinter 
        int rp = height.size()-1; // right pointer

        while(lp<rp) {
            // calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp-lp;

            int currWater = ht*width;

            maxWater = Math.max(maxWater, currWater);
            
            // update the pointers
            if(height.get(lp) < height.get(rp)) {
                lp++;
            } else { // lp>rp
                rp--;
            }
        }
        return maxWater;
    }

    public static int waterContainer(ArrayList<Integer> height) { // brute force O(n^2)
        int maxWater = 0;

        for(int i=0; i<height.size(); i++) { 
            for(int j=i+1; j<height.size(); j++) {
                
                int ht = Math.min(height.get(i), height.get(j));
                int width = j-i;
                int currWater = ht*width;

                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5); // height = [1 8 6 2 5 4 8 3 7]
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(waterContainer(height));
        System.out.println(StoreWater(height));
    }

}
