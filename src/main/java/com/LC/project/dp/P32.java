package com.LC.project.dp;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/11
 */
public class P32 {
    // dp 太难了
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (
                        i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('
                )
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
        }
        for (int j : dp) {
            maxans = Math.max(maxans, j);
        }
        return maxans;
    }
}
