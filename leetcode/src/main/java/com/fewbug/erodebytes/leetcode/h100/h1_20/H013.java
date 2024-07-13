package com.fewbug.erodebytes.leetcode.h100.h1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/11 14:59
 **/
public class H013 {

    /**
     * 提示：
     * <p>
     * 1 <= n <= 8
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        char[] select = new char[]{'(', ')'};
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTracing(res, select, sb, 0, n, 0, 0);
        return res;
    }

    private void backTracing(List<String> res, char[] select, StringBuilder sb, int i, int n, int left, int right) {
        if (right > left) {
            return;
        }
        if (i == 2 * n) {
            if (right == left) {
                res.add(sb.toString());
            }
            return;
        }
        for (int j = 0; j < select.length; j++) {
            char c = select[j];
            sb.append(c);
            left = j == 0 ? left + 1 : left;
            right = j == 1 ? right + 1 : right;
            backTracing(res, select, sb, i + 1, n, left, right);
            left = j == 0 ? left - 1 : left;
            right = j == 1 ? right - 1 : right;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> optimize(int n) {
        List<String> selectList = Arrays.asList("()");
        if (n == 1) {
            return selectList;
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTracing(res, sb, n, 0, 0);
        return res;
    }

    private void backTracing(List<String> res, StringBuilder sb, int n, int open, int close) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backTracing(res, sb, n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backTracing(res, sb, n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
