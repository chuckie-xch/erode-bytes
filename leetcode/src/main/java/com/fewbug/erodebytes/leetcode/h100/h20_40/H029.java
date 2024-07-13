package com.fewbug.erodebytes.leetcode.h100.h20_40;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/13 20:47
 **/
public class H029 {

    /**
     * 70. 爬楼梯
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 45
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        return solution(n);
    }

    private int solution(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre = 2, prePre = 1;
        int index = 3;
        int cur = 0;
        while (index <= n) {
            cur = pre + prePre;
            prePre = pre;
            pre = cur;
            index++;
        }
        return cur;
    }
}
