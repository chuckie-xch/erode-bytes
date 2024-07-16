package com.fewbug.erodebytes.leetcode.h100.h40_60;

import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/16 12:17
 **/
public class H049 {

    /**
     * 提示：
     * <p>
     * 1 <= s.length <= 300
     * 1 <= wordDict.length <= 1000
     * 1 <= wordDict[i].length <= 20
     * s 和 wordDict[i] 仅由小写英文字母组成
     * wordDict 中的所有字符串 互不相同
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i < len + 1; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    flag = true;
                    break;
                }
            }
            dp[i] = flag;
        }
        return dp[len];
    }


}
