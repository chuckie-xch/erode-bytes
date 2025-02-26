package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

import java.util.HashMap;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/24 08:56
 **/
public class Q08 {

    /**
     * 0 <= s.length <= 5 * 104 s 由英文字母、数字、符号和空格组成
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n < 2) {
            return n;
        }
        int l = 0, r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < n) {
            char cur = arr[r];
            if (map.containsKey(cur) && map.get(cur) >= l) {
                ans = Math.max(ans, r - l);
                l = map.get(cur) + 1;
            }
            map.put(cur, r);
            r++;
        }
        ans = Math.max(ans, r - l);
        return ans;
    }

    public int solution(String s) {
        int ans = 0;
        int n = s.length();
        if (n < 2) {
            return n;
        }
        char[] arr = s.toCharArray();
        int l = 0, r = 1;
        int[] cnt = new int[128];
        cnt[arr[l]]++;
        while (r < n) {
            char cur = arr[r];
            cnt[cur]++;
            while (cnt[cur] > 1) {
                cnt[arr[l]]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
