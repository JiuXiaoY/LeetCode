package com.LC.project.linkedlist;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/31
 */
public class P19 {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode first = head;
        ListNode second = dummy;

        // Move first pointer so that the gap between first and second is n nodes apart
        while (n > 0 && first != null) {
            first = first.next;
            n--;
        }

        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Skip the desired node
        second.next = second.next.next;

        return dummy.next;
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
