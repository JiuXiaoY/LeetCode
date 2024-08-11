package com.LC.project.dp;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/11
 */
public class P300 {

    // 每往后遍历一个数字
    // 首先只考虑当前数字，则赋值为 1
    // 然后考虑当前数字之前的数字，如果当前数字大于之前的数字，
    // 则当前数字的值为当前数字的值和当前数字之前的数字的值加一的最大值
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // 贪心加二分查找
}
