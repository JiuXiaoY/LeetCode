package com.LC.project.hash;

import java.util.HashMap;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/27
 */
public class SumOfTwoNumbers {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        // 对应值和下标
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(target - nums[i])) {
                return new int[]{res.get(target - nums[i]), i};
            }
            res.put(nums[i], i);
        }
        throw new RuntimeException("没有找到");
    }
}
