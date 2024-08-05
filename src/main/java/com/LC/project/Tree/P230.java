package com.LC.project.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/3
 */
public class P230 {
    public static void main(String[] args) {

    }

    public static int kthSmallest(TreeNode root, int k) {
        // 中序遍历 第 k 个节点就是所要的值
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans.get(k - 1);
    }

    private static void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
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
