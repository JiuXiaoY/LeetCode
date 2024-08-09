package com.LC.project.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/9
 */
public class P763 {
    public static void main(String[] args) {

    }

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
