package com.LC.project.dp;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/6
 */
public class P132 {
    public static void main(String[] args) {
        P132 p132 = new P132();
        System.out.println(p132.minCut("abba"));
    }

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        // 初始化 dp 数组
        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1; // 最坏情况下，每个字符之间都切割一次
        }

        for (int i = 0; i < n; i++) {
            // 奇数回文串
            for (int j = 0; i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j); j++) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], dp[i - j] + 1);
            }

            // 偶数回文串
            for (int j = 1; i - j + 1 >= 0 && i + j < n && s.charAt(i - j + 1) == s.charAt(i + j); j++) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], dp[i - j + 1] + 1);
            }
        }

        return dp[n];
    }
}
