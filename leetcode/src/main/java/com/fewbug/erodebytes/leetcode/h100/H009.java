package com.fewbug.erodebytes.leetcode.h100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/10 17:22
 **/
public class H009 {

    /**
     * 0 <= digits.length <= 4
     * digits[i] 是范围 ['2', '9'] 的一个数字。
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        String[] numsArr = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backTracing(res, numsArr, digits, 0, sb);

        return res;
    }

    private void backTracing(List<String> res, String[] numsArr, String digits, int i, StringBuilder sb) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String str = numsArr[digits.charAt(i) - '0'];
        for (int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            backTracing(res, numsArr, digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
