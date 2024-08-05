package com.LC.project.Tree;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/2
 */
public class P543 {
    public static void main(String[] args) {

    }

    // 忘记考虑穿不穿过根节点的情况了
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        maxDiameter = Math.max(maxDiameter, left + right); // 更新最大直径
        return Math.max(left, right) + 1; // 返回当前节点的深度
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
