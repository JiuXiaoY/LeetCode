package com.LC.project.linkedlist;

import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/30
 */
public class P234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(1)))));
        boolean palindrome = isPalindrome(head);
        if (palindrome) {
            System.out.println("1111");
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode temp = new ListNode(head.val);
        ListNode current = head;
        while (current.next != null) {
            temp = new ListNode(current.next.val, temp);
            current = current.next;
        }

        while (temp.next != null) {
            if (temp.val != head.val) {
                return false;
            }
            temp = temp.next;
            head = head.next;
        }
        return true;
    }


    // 快慢指针也是可以的
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
