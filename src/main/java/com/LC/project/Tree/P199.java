package com.LC.project.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/3
 */
public class P199 {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (i == size - 1) {
                        res.add(node.val);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return res;
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

/*
 每层只能进去一个元素
 class Solution {
     public List<Integer> rightSideView(TreeNode root) {
         List<Integer> list = new ArrayList<>();
         if(root == null){
             return list;
         }
         travel(root,list,0);
         return list;
     }
     public void travel(TreeNode root,List<Integer> list,int deep){
         if(root==null){
             return;
         }
         if(deep>=list.size()){
             list.add(root.val);
         }
         travel(root.right,list,deep+1);
         travel(root.left,list,deep+1);
     }
 }
*/
