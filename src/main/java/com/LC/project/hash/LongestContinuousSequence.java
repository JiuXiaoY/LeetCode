package com.LC.project.hash;

import java.util.HashSet;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/27
 */
public class LongestContinuousSequence {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }

        int max = 0;

        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int count = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
