package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/6 19:56
 **/
public class Q15 {

    /**
     * m == s.length <br>
     * n == t.length <br>
     * 1 <= m, n <= 105 <br>
     * s 和 t 由英文字母组成 <br>
     * 
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int need = t.length();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        if (sArr.length < t.length()) {
            return "";
        }
        int[] map = new int[128];
        for (int i = 0; i < tArr.length; i++) {
            map[tArr[i]]++;
        }
        int l = 0, r = 0, lIndex = 0, rIndex = 0;
        int minLength = Integer.MAX_VALUE;
        while (r < sArr.length) {
            int x = sArr[r];
            map[x]--;
            if (map[x] >= 0) {
                need--;
            }
            if (need == 0) {
                while (map[sArr[l]] < 0) {
                    map[sArr[l]]++;
                    l++;
                }
                if (minLength > r - l + 1) {
                    minLength = r - l + 1;
                    lIndex = l;
                    rIndex = r;
                }
                need++;
                map[sArr[l]]++;
                l++;
            }
            r++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(lIndex, rIndex + 1);
    }
}
