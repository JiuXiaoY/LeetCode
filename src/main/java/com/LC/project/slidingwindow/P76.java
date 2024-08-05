package com.LC.project.slidingwindow;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/28
 */
public class P76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    /**
     * 76. 最小覆盖子串
     *
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     * 思路：
     *  1. 创建一个数组cnt，用于记录t中每个字符出现的次数。
     *  2. 创建两个指针l和r，用于记录窗口的左右边界。
     *  3. 创建一个变量cntT，用于记录t中每个字符出现的次数。
     *
     *  4。循环遍历s，使用两个指针l和r，l指向窗口的左边界，r指向窗口的右边界。
     *  5.移动右边界，如果当前字符在t中，则将cntT减1。完全覆盖时，值为 0
     *  6.开始移动左边界，如果当前字符在t中且数组值为 0，则将cntT加1。因为可能出现重复的字符，所以需要判断数组值是否为 0。
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (int i = 0; i < t.length(); i++) cnt[t.charAt(i)]++;
        int l = 0, r = 0, ansL = 0, ansR = 0, ans = Integer.MAX_VALUE, cntT = t.length();
        while (r < s.length()) {
            if (cnt[s.charAt(r++)]-- > 0) cntT--;
            while (cntT == 0) {
                if (r - l < ans) {
                    ans = r - l;
                    ansL = l;
                    ansR = r;
                }
                if (cnt[s.charAt(l++)]++ == 0) cntT++;
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);
    }
}
