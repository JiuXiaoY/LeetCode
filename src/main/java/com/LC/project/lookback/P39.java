package com.LC.project.lookback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/5
 */
public class P39 {

    public static void main(String[] args) {
        P39 p39 = new P39();
        List<List<Integer>> lists = p39.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();

        }
        backTrack(candidates, target, 0);
        return res;
    }

    private void backTrack(int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = start; j < candidates.length; j++) {
            path.add(candidates[j]);
            backTrack(candidates, target - candidates[j], j);
            path.remove(path.size() - 1);
        }

    }

}
