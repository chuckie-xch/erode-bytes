package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/21 09:34
 **/
public class Q06 {

    /**
     * 1 <= cardPoints.length <= 10^5 1 <= cardPoints[i] <= 10^4 1 <= k <= cardPoints.length
     * 
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int ans = 0;
        int n = cardPoints.length;
        for (int i = 0; i < n + k; i++) {
            int index = getRealIndex(i, n);
            sum += cardPoints[index];
            if (i + 1 < k) {
                continue;
            }
            if (i + 1 == k || i >= n - 1) {
                ans = Math.max(ans, sum);
            }
            int outIndex = getRealIndex(i - k + 1, n);
            sum -= cardPoints[outIndex];
        }
        return ans;
    }

    private int getRealIndex(int i, int n) {
        if (i < n) {
            return i;
        }
        return i - n;
    }

    public int solution(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int ans = sum;
        for (int i = 1; i <= k; i++) {
            sum -= cardPoints[k - i];
            sum += cardPoints[n - i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
