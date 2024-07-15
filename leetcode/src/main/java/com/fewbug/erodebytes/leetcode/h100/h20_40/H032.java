package com.fewbug.erodebytes.leetcode.h100.h20_40;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/14 14:40
 **/
public class H032 {

    /**
     * 提示：
     * <p>
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 105
     * s 和 t 由英文字母组成
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < arr2.length; i++) {
            map[arr2[i]]++;
        }
        int l = 0, r = 0;
        int start = 0, end = -1;
        int minLength = Integer.MAX_VALUE;
        int need = arr2.length;
        while (r < arr1.length) {
            map[arr1[r]]--;
            if (map[arr1[r]] >= 0) {
                need--;
            }
            if (need == 0) {
                while (map[arr1[l]] < 0) {
                    map[arr1[l++]]++;
                }
                if (minLength > r - l + 1) {
                    start = l;
                    end = r;
                    minLength = r - l + 1;
                }
                map[arr1[l]]++;
                need++;
                l++;
            }
            r++;
        }

        return s.substring(start, end + 1);
    }
}
