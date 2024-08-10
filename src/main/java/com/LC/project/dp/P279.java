package com.LC.project.dp;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/10
 */
public class P279 {
    public static void main(String[] args) {

    }


    // 四平方和定理
    // ..........


    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                // 然后对于每个 j * j <= i，
                // 更新 dp[i] 为 dp[i - j * j] + 1 和当前 dp[i] 中的较小值。
                // 这里的 dp[i - j * j] + 1 表示将 i 分解为 j * j 加上剩余部分 i - j * j 所需的完全平方数的数量。
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
