package com.LC.project.lookback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/5
 */
public class P78 {
    public static void main(String[] args) {

    }

    // 牛逼的方法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> path = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    path.add(nums[j]);
                }
            }
            res.add(path);
        }
        return res;
    }

    // 还可以通过拷贝子集来求解，每加一个数字 n，就拷贝一份原子集，全部加上 n，然后放回去
    // 回溯递归，在每一步，有两种选择：
    // 选择当前元素 nums[cur] 并继续递归。
    // 不选择当前元素 nums[cur] 并继续递归。
}
