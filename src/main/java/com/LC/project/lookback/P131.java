package com.LC.project.lookback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/6
 */
public class P131 {
    public static void main(String[] args) {

    }

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrack(s, 0);
        return res;
    }

    boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i))
                return false;
        }
        return true;
    }

    void backTrack(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 实际上就是从每个字母开始判断
        // 因为单个字母必然是回文字符串，只需要往后面添加字母，然后判断，
        // 返回的就是以该字母为首地所有回文字符串了
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s.substring(startIndex, i + 1))) {
                path.add(s.substring(startIndex, i + 1));
                backTrack(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

}
