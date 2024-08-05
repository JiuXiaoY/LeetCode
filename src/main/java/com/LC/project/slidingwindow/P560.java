package com.LC.project.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/27
 */
public class P560 {
    public static void main(String[] args) {

    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
