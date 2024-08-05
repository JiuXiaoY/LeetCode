package com.LC.project.ordinaryarray;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/28
 */
public class P53 {
    public static void main(String[] args) {
        int[] nums = {4,-1,-1,-6,5};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            max = Math.max(max, sum);
        }
        return max;
    }
}
