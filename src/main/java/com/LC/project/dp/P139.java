package com.LC.project.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/11
 */
public class P139 {

    public static void main(String[] args) {
        List<String> wordDict = List.of("leet", "code");
        System.out.println(Solution.wordBreak("leetcode", wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }

    // 字典树

    public static class Solution {
        private static TrieNode root;

        // 插入单词到字典树中
        private static void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isWord = true;
        }

        public static boolean wordBreak(String s, List<String> wordDict) {
            root = new TrieNode();

            // Build the Trie from the dictionary
            for (String word : wordDict) {
                // 反转插入
                insert(new StringBuilder(word).reverse().toString());
            }

            int n = s.length();
            boolean[] f = new boolean[n + 1];
            f[0] = true;

            for (int i = 1; i <= n; ++i) {
                TrieNode node = root;
                for (int j = i - 1; j >= 0; --j) {
                    if (node != null) {
                        char c = s.charAt(j);
                        node = node.children[c - 'a'];
                        if (node != null && node.isWord && f[j]) {
                            f[i] = true;
                            break;
                        }
                    }
                }
            }

            return f[n];
        }

        static class TrieNode {
            TrieNode[] children;
            boolean isWord;

            public TrieNode() {
                children = new TrieNode[26]; // 假设字母都是小写字母
                isWord = false;
            }
        }
    }

}
