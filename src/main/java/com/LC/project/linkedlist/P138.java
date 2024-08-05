package com.LC.project.linkedlist;

import java.util.*;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/1
 */
public class P138 {
    public static void main(String[] args) {

    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            if (cur.random != null) {
                map.get(cur).random = map.get(cur.random);
            }
            cur = cur.next;
        }

        return map.get(head);
    }

    // Definition for a Node.
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
