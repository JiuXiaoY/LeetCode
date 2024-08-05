package com.LC.project.linkedlist;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/31
 */
public class P21 {
    public static void main(String[] args) {
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode res;
        ListNode ans;
        if (list1.val < list2.val) {
            res = list1;
            ans = res;
            list1 = list1.next;
        } else {
            res = list2;
            ans = res;
            list2 = list2.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }

        if (list1 != null) {
            res.next = list1;
        }
        if (list2 != null) {
            res.next = list2;
        }

        return ans;
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
