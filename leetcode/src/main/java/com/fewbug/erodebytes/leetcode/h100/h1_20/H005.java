package com.fewbug.erodebytes.leetcode.h100.h1_20;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/9 22:27
 **/
public class H005 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int len = s.length();
        int maxLength = 0;
        int maxStart = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;
                while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                left++;
                right--;
                if (maxLength < right - left + 1) {
                    maxLength = right - left + 1;
                    maxStart = left;
                }
            }
        }
        return s.substring(maxStart, maxStart + maxLength);

    }
}
