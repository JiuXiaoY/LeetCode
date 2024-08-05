package com.LC.project.linkedlist;

import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/1
 */
public class P148 {
    public static void main(String[] args) {

    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        // 得到链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        // 归并排序
        // 头节点
        ListNode dummyHead = new ListNode(0, head);
        // 初始子长度为 1
        for (int subLen = 1; subLen < length; subLen <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                // 第一个子链表的头节点
                ListNode head1 = curr;
                for (int i = 1; i < subLen && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 第二个子链表的头节点
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLen && curr != null; i++) {
                    curr = curr.next;
                }
                // 断开两个子链表
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                // 合并两个子链表
                prev.next = merge(head1, head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
