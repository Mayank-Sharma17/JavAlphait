public class array3 {

    // TRAPPING RAINWATER and T.C of this code = O(n)

    public static int trappedRainwater(int height[]) {
        int n = height.length;

        // calculate left max boundary
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // calculate right max boundary
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        // loop
        for (int i = 0; i < n; i++) {
            // calculate water level= min(leftmax bound. leftmax bound)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // calclate water trapped= waterlevel - height[i]
            trappedWater += waterLevel - height[i];

        }
        return trappedWater;
    }

    // BUY AND SELL STOCKS and T.C = O(n)

    public static int buyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE; // storing +infinity
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) { // profit

                int profit = prices[i] - buyPrice; // today's profit
                maxProfit = Math.max(maxProfit, profit); // global
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println("Water trapped between the bars = " +trappedRainwater(height));

        // int prices[] = { 7, 1, 5, 3, 6, 4 };
        // System.out.println("our max profit is = " + buyAndSellStocks(prices));
    }

}
