package com.LC.project.Tree;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/4
 */
public class P124 {
    public static void main(String[] args) {

    }

    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    // 核心思想还是递归，递归返回当前节点的最大贡献值
    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        max = Math.max(max, root.val + left + right);
        // 返回当前节点的最大贡献值
        return root.val + Math.max(left, right);
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
