package com.fewbug.erodebytes.leetcode.h100.h60_80;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/19 15:38
 **/
public class H077 {

    /**
     * 提示：
     * <p>
     * 1 <= s.length <= 25
     * s 由小写英文字母以及括号 '(' 和 ')' 组成
     * s 中至多含 20 个括号
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        int len = s.length();
        if (len <= 1) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        remove(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }

    private void remove(List<String> res, String str, int checkIndex, int removeIndex, char[] c) {
        int count = 0;
        for (int i = checkIndex; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == c[0]) {
                count++;
            } else if (cur == c[1]) {
                count--;
            }
            if (count < 0) {
                for (int j = removeIndex; j <= i; j++) {
                    if (str.charAt(j) == c[1] && (j == removeIndex || str.charAt(j) != str.charAt(j - 1))) {
                        String newStr = str.substring(0, j) + str.substring(j + 1);
                        remove(res, newStr, i, j, c);
                    }
                }
                return;
            }
        }
        String sb = new StringBuilder(str).reverse().toString();
        if (c[0] == '(') {
            remove(res, sb.toString(), 0, 0, new char[]{')', '('});
        } else {
            res.add(sb.toString());
        }
    }
}
