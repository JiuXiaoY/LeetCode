package com.LC.project.greedy;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/9
 */
public class P45 {
    public static void main(String[] args) {
        System.out.println(new P45().jump(new int[]{1,2,3}));
    }

    public int jump(int[] nums) {
        int result = 0;       // 记录跳跃次数
        int maxReach = 0;     // 当前能够到达的最远位置
        int end = 0;          // 当前跳跃的范围边界
        // 当前的位置

        // 遍历数组，但不需要遍历最后一个元素
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新当前能够到达的最远位置
            maxReach = Math.max(maxReach, i + nums[i]);

            // 如果到达了当前跳跃的边界，则必须进行一次跳跃
            if (i == end) {
                result++;   // 增加跳跃次数
                end = maxReach;  // 更新跳跃边界

                // 如果已经可以到达或超过数组末尾，则直接结束
                if (end >= nums.length - 1) {
                    break;
                }
            }
        }

        return result;
    }
}
