package com.LC.project.twopointers;

import java.util.Arrays;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/27
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZeroes(nums)));
    }

    public static int[] moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        while (count < nums.length) {
            nums[count++] = 0;
        }
        return nums;
    }

}
