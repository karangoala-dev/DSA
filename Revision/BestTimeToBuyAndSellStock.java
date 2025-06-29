package Revision;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < prices.length; i++){
            res = Math.max(prices[i] - minSoFar, res);
            minSoFar = Math.min(minSoFar, prices[i]);
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
