package com.fewbug.erodebytes.leetcode.h100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/11 23:43
 **/
public class H016 {

    /**
     * 0 <= s.length <= 3 * 104
     * s[i] 为 '(' 或 ')'
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int len = s.length();
        int res = 0;

        char[] arr = s.toCharArray();
        int open = 0;
        int close = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                res = Math.max(res, close);
            } else if (close > open) {
                open = 0;
                close = 0;
            }
        }

        open = 0;
        close = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                res = Math.max(res, close);
            } else if (open > close) {
                open = 0;
                close = 0;
            }
        }

        return res * 2;
    }

    public int solution1(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int len = s.length();
        char[] arr = s.toCharArray();
        int[] dp = new int[len];
        int res = 0;

        for (int i = 1; i < len; i++) {
            if (arr[i] == ')') {
                if (arr[i - 1] == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && arr[i - dp[i - 1] - 1] == '(') {
                        dp[i] = ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
