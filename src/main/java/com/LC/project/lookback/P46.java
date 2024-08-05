package com.LC.project.lookback;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/4
 */
public class P46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        new P46().permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        for (Integer num : nums) {
            path.add(num);
        }

        int n = nums.length;
        backTrack(n, path, res, 0);
        return res;
    }

    public void backTrack(int n, List<Integer> path, List<List<Integer>> res, int start) {
        if (start == n) {
            res.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }

        for (int i = start; i < n; i++) {
            Collections.swap(path, start, i);
            backTrack(n, path, res, start + 1);
            Collections.swap(path, start, i);
        }
    }

}
