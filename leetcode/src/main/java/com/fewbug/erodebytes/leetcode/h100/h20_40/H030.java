package com.fewbug.erodebytes.leetcode.h100.h20_40;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/13 20:59
 **/
public class H030 {

    /**
     * 提示：
     * <p>
     * 0 <= word1.length, word2.length <= 500
     * word1 和 word2 由小写英文字母组成
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0 && len2 == 0) {
            return 0;
        }
        if (len1 == 0 || len2 == 0) {
            return Math.max(len1, len2);
        }

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int insert = dp[i][j - 1] + 1;
                    int replace = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                    int remove = dp[i - 1][j] + 1;
                    dp[i][j] = Math.min(remove, Math.min(insert, replace));
                }
            }
        }

        return dp[len1][len2];
    }
}
