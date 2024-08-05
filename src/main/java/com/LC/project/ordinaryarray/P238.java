package com.LC.project.ordinaryarray;

import java.util.Arrays;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/29
 */
public class P238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    /**
     * 前积乘后积
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int front = 1;
        int back = 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = front;
            front = front * nums[i];
        }
        for (int j = n - 1; j >= 0; j--) {
            res[j] = res[j] * back;
            back = back * nums[j];
        }
        return res;
    }
}
