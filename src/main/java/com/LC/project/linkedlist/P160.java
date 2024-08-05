package com.LC.project.linkedlist;

import java.util.HashSet;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/30
 */
public class P160 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(1);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        HashSet<ListNode> temp = new HashSet<>();
        ListNode p = headA;
        while (p != null) {
            temp.add(p);
            p = p.next;
        }
        while (headB != null) {
            if (temp.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
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
