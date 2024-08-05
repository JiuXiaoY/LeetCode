package com.LC.project.linkedlist;

import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/30
 */
public class P206 {
    public static void main(String[] args) {
        // 创建一个链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        // 反转链表
        ListNode reversedHead = reverseList(head);

        // 输出反转后的链表
        printList(reversedHead);

        // 创建一个空链表
        ListNode emptyHead = null;

        // 反转空链表
        ListNode reversedEmptyHead = reverseList(emptyHead);

        // 输出反转后的空链表
        System.out.println("Reversed empty list: " + (reversedEmptyHead == null ? "null" : "not null"));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next; // 保存下一个节点
            current.next = prev; // 反转指针
            prev = current;      // 移动 prev 指针
            current = next;      // 移动 current 指针
        }
        return prev; // 返回新的头结点
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

    // 打印链表的辅助方法
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
