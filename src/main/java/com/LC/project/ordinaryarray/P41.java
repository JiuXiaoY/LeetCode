package com.LC.project.ordinaryarray;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/29
 */
public class P41 {
    public static void main(String[] args) {

    }

    /**
     * 实际上，对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中。
     * <p>
     * 无语死了
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 大于 0，且没出现过才交换
            while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
