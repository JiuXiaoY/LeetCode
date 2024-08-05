package com.LC.project.lookback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/5
 */
public class P22 {
    public static void main(String[] args) {
        System.out.println(new P22().generateParenthesis(3));
    }

    List<String> res = new ArrayList<>();

    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backTrack(n, n);
        return res;
    }

    public void backTrack(int left, int right) {
        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        }

        if (left > 0) {
            path.append("(");
            backTrack(left - 1, right);
            path.deleteCharAt(path.length() - 1);
        }

        if (right > left) {
            path.append(")");
            backTrack(left, right - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
