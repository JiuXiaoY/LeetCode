package com.LC.project.graphtheory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/4
 */
public class P208 {
    public static void main(String[] args) {
        // 回溯
    }
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    return false;
                }
            }
            return node.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}
