package com.LC.project.linkedlist;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/31
 */
public class P2 {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode head = prehead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            head.next = new ListNode(sum);
            head = head.next;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }
        return prehead.next;
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
