package com.LC.project.Tree;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/3
 */
public class P105 {

    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // 递归终止条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 得到根节点的值
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        // 找到根节点在中序遍历中的位置
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        // 递归调用
        // 根节点在中序遍历中的位置 - 左子树的长度 = 右子树的长度
        root.left = buildTree(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index - 1);
        root.right = buildTree(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd);
        return root;
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
