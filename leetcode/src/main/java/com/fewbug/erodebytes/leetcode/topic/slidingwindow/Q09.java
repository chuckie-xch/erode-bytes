package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/26 09:08
 **/
public class Q09 {

    /**
     * 2 <= s.length <= 100 s 仅由小写英文字母组成。
     * 
     * @param s
     * @return
     */
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        int l = 0;
        int[] cnt = new int[128];
        for (int r = 0; r < s.length(); r++) {
            int cur = s.charAt(r);
            cnt[cur]++;
            while (cnt[cur] > 2) {
                cnt[s.charAt(l)]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
