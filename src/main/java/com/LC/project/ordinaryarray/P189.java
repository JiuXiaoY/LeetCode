package com.LC.project.ordinaryarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/28
 */
public class P189 {
    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    public static void rotate(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // 确保k在数组长度范围内
        k = k % nums.length;

        // 逆序三次来实现旋转
        Collections.reverse(list);
        Collections.reverse(list.subList(0, k));
        Collections.reverse(list.subList(k, nums.length));

        // 将List转换回数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
    }

    public static void rotate1(int[] nums, int k) {
        k = k % nums.length; // 确保k在数组长度范围内
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
