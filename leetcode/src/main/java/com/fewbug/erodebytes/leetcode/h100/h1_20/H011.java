package com.fewbug.erodebytes.leetcode.h100.h1_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/10 18:59
 **/
public class H011 {

    /**
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || (s.length() & 1) != 0) {
            return false;
        }
        int len = s.length();
        Map<Character, Character> pair = new HashMap<>();
        pair.put('(', ')');
        pair.put('[', ']');
        pair.put('{', '}');

        Stack<Character> stack = new Stack();

        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (pair.containsKey(cur)) {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pre = stack.pop();
                if (!pair.containsKey(pre) || !pair.get(pre).equals(cur)) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
