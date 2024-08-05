package com.LC.project.linkedlist;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/1
 */
public class P23 {
    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public static ListNode mergeKLists(ListNode[] lists, int left, int right) {
        // 如果左右指针重合，说明只有一个链表，直接返回
        if (left == right) return lists[left];
        if (left > right) return null;
        int mid = (right + left) / 2;

        ListNode l1 = mergeKLists(lists, left, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, right);

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newHead = new ListNode(-1);
        ListNode prehead = newHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                prehead.next = cur1;
                prehead = prehead.next;
                cur1 = cur1.next;
            } else {
                prehead.next = cur2;
                prehead = prehead.next;
                cur2 = cur2.next;
            }
        }

        if(cur1!=null) prehead.next=cur1;
        if(cur2!=null) prehead.next=cur2;

        return newHead.next;
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
