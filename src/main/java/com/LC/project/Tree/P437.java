package com.LC.project.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/3
 */
public class P437 {
    public static void main(String[] args) {
    }

    public static int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, targetSum, 0);
    }

    public static int dfs(TreeNode root, Map<Long, Integer> prefix, long targetSum, long currSum) {
        if (root == null) {
            return 0;
        }
        currSum += root.val;
        long res = prefix.getOrDefault(currSum - targetSum, 0);
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);
        res += dfs(root.left, prefix, targetSum, currSum);
        res += dfs(root.right, prefix, targetSum, currSum);
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) - 1);
        return (int) res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
