package com.LC.project.linkedlist;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/31
 */
public class P24 {
    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(0, head);
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = cur.next.next;
            cur.next.next = temp;
            cur = cur.next.next;
        }
        return res.next;
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
