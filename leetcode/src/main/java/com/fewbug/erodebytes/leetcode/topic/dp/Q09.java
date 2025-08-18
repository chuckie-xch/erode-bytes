package com.fewbug.erodebytes.leetcode.topic.dp;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/8/18 10:30
 **/
public class Q09 {

    private long[] memo;

    /**
     * 提示：
     *
     * 1 <= questions.length <= 105 <br>
     * questions[i].length == 2 <br>
     * 1 <= pointsi, brainpoweri <= 105 <br>
     * 
     * @param questions
     * @return
     */
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        memo = new long[n];
        return dfs(0, questions, n);
    }

    public long dfs(int i, int[][] questions, int n) {
        if (i > n - 1) {
            return 0;
        }
        if (i == n - 1) {
            return questions[i][0];
        }
        if (memo[i] != 0) {
            return memo[i];
        }
        long res = Math.max(questions[i][0] + dfs(i + questions[i][1] + 1, questions, n), dfs(i + 1, questions, n));
        return memo[i] = res;
    }

    public long solution(int[][] questions) {
        int n = questions.length;
        long[] f = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int j = Math.min(n, questions[i][1] + 1 + i);
            f[i] = Math.max(f[i + 1], questions[i][0] + f[j]);
        }
        return f[0];
    }
}
