package com.LC.project.deftly;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/13
 */
public class P136 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
