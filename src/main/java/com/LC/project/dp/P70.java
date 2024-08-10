package com.LC.project.dp;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/10
 */
public class P70 {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
