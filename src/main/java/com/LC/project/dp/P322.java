package com.LC.project.dp;

import java.util.Arrays;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/10
 */
public class P322 {
    public static void main(String[] args) {
        System.out.println(new P322().coinChange(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }

        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
