package com.fewbug.erodebytes.leetcode.h100;

import java.util.HashSet;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/9 16:33
 **/
public class H003 {

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int l = 0, r = 1;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(l));
        while (r < n) {
            while (r < n && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            res = Math.max(res, r - l);
            set.remove(s.charAt(l));
            l++;
        }

        return res;
    }

}
