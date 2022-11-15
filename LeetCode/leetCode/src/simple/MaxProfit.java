package simple;

import java.util.Arrays;

public class MaxProfit {
    public static void main(String[] args) {
        int[] ints = {4,5,1};
        System.out.println(maxProfit(ints));

    }
    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;

    }
}
