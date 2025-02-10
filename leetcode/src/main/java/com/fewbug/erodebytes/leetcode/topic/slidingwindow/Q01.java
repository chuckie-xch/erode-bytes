package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/10 11:15
 **/
public class Q01 {

    /**
     * 1 <= s.length <= 10^5
     * s 由小写英文字母组成
     * 1 <= k <= s.length
     *
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        int ans = 0;
        int vowel = 0;
        int l = 0, r = 0;
        int n = s.length();
        boolean[] flag = new boolean[n];
        while (r < n) {
            while (r - l + 1 <= k) {
                char c = s.charAt(r);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    flag[r] = true;
                    vowel++;
                }
                r++;
            }
            ans = Math.max(ans, vowel);
            vowel -= flag[l] ? 1 : 0;
            l++;
        }
        return ans;
    }

    public int solution(String s, int k) {
        char[] arr = s.toCharArray();
        int ans = 0;
        int vowel = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            }
            if (i + 1 < k) {
                continue;
            }
            ans = Math.max(ans, vowel);
            char out = arr[i - k + 1];
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                vowel--;
            }
        }
        return ans;
    }
}
