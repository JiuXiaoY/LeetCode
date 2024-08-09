package com.LC.project.greedy;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/9
 */
public class P55 {
    public static void main(String[] args) {
        P55 solution = new P55();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(nums));  // 应输出 true
    }

    public boolean canJump(int[] nums) {
        // 记录当前能够跳到的最远位置
        int maxReach = 0;
        // 遍历数组中的每一个位置
        for (int i = 0; i < nums.length; i++) {
            // 如果当前的位置已经超出了能够跳到的最远位置，则无法到达终点
            if (i > maxReach) {
                return false;
            }
            // 更新最远能够跳到的位置
            maxReach = Math.max(maxReach, i + nums[i]);
            // 如果最远位置已经到达或超过最后一个位置，返回 true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
