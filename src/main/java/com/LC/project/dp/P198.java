package com.LC.project.dp;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/10
 */
public class P198 {
    public static void main(String[] args) {
        System.out.println(new P198().rob(new int[]{1, 2, 3, 1,1000}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
