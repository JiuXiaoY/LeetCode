package com.LC.project.lookback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/5
 */
public class P17 {
    public static void main(String[] args) {
        List<String> list = new P17().letterCombinations("23");
        System.out.println(list);
    }

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        // String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // List<String> res = new ArrayList<>();
        // backTrack(digits, mapping, res, 0, "");
        backTrack(digits, 0);
        return res;
    }

    public void backTrack(String digits, String[] mapping, List<String> res, int start, String path) {
        if (path.length() == digits.length()) {
            res.add(path);
            return;
        }

        String letters = mapping[digits.charAt(start) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            backTrack(digits, mapping, res, start + 1, path + letters.charAt(i));
        }
    }

    public void backTrack(String digits, int start) {
        if (start == digits.length()) {
            res.add(path.toString());
            return;
        }

        String str = mapping[digits.charAt(start) - '0'];
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            backTrack(digits, start + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
