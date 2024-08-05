package com.LC.project.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/27
 */
public class P438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        char[] windowA = s.toCharArray();
        char[] windowB = p.toCharArray();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(windowB);
        for (int i = 0; i < windowA.length - windowB.length + 1; i++) {
            char[] temp = Arrays.copyOfRange(windowA, i, i + windowB.length);
            Arrays.sort(temp);
            if (Arrays.equals(temp, windowB)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
