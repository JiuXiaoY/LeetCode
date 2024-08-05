package com.LC.project.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple implementation of an LRU-like cache with capacity and count-based eviction strategy.
 * When the cache is full, it removes the least frequently used element.
 * Note: This implementation is not thread-safe.
 *
 * @author JXY
 * @version 1.1
 * @since 2024/8/1
 */
public class P146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 应该返回 1
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4); // 应该移除 key 2
        System.out.println(cache.get(1)); // 应该返回 -1，因为 key 2 被移除了
        System.out.println(cache.get(3)); // 应该返回 3
        System.out.println(cache.get(4)); // 应该返回 4
    }

    public static class LRUCache {

        // 缓存
        private final Map<Integer, Node> cache;
        // 容量
        private final int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>(capacity);
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node != null) {
                node.count++;
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cache.size() >= this.capacity && !cache.containsKey(key)) {
                // 移除最近最少使用的节点
                int minCount = Integer.MAX_VALUE;
                int keyToRemove = -1;
                // 找到 count 最小的元素
                for (Map.Entry<Integer, Node> entry : cache.entrySet()) {
                    Node node = entry.getValue();
                    if (node.count < minCount) {
                        minCount = node.count;
                        keyToRemove = entry.getKey();
                    }
                }
                if (keyToRemove != -1) {
                    System.out.println("lllll"+keyToRemove);
                    cache.remove(keyToRemove);
                }
            }
            // 更新或添加新的节点
            cache.put(key, new Node(value, cache.containsKey(key) ? cache.get(key).count + 1 : 0));
        }

        public static class Node {
            int val;
            int count;

            public Node(int val, int count) {
                this.val = val;
                this.count = count;
            }
        }
    }
}
