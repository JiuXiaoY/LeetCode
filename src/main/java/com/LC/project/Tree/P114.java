package com.LC.project.Tree;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/3
 */
public class P114 {
    public static void main(String[] args) {

    }

    public static void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }


    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode() {
        }

        TreeNode(int val) {
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
        }
    }
}
