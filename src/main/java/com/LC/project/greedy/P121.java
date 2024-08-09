package com.LC.project.greedy;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/9
 */
public class P121 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
