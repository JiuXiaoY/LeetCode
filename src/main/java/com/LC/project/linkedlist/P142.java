package com.LC.project.linkedlist;

import java.util.HashSet;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/30
 */
public class P142 {
    public static void main(String[] args) {

    }

    public static ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    public static ListNode hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
