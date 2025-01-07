package com.fewbug.erodebytes.leetcode.daily.year25.m01;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/1/7 09:19
 **/
public class Day07 {

    /**
     * 提示：
     * <p>
     * 1 <= s.length <= 100
     * s 仅由英文大写字母和小写字母组成。
     *
     * @param s
     * @return
     */
    public int countKeyChanges(String s) {
        int index = 0;
        int count = 0;
        char pre = s.charAt(index++);
        while (index < s.length()) {
            char cur = s.charAt(index++);
            if (Character.toLowerCase(cur) == Character.toLowerCase(pre)) {
                continue;
            } else {
                count++;
            }
            pre = cur;
        }
        return count;
    }

    public int solution(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(i - 1))) {
                ans++;
            }
        }
        return ans;
    }
}
