package com.LC.project.twopointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/27
 */
public class SumOfThreeNumbers {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return list;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 如果大于 0
            if (nums[i] > 0) return list;
            // 相等
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 左右指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0)
                    left++;
                else right--;
            }
        }

        return list;
    }

    public static List<List<Integer>> threeSumMy(int[] nums) {
        // 储存结果
        List<List<Integer>> res = new ArrayList<>();
        // 处理错误
        if (nums.length < 3) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 大于 0
            if (nums[i] > 0) return res;
            // 相等
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else right--;
            }
        }
        return res;
    }
}
