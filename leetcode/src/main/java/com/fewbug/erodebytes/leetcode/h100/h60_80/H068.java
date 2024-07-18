package com.fewbug.erodebytes.leetcode.h100.h60_80;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/18 15:31
 **/
public class H068 {

    /**
     * 提示：
     * <p>
     * 2 <= nums.length <= 105
     * -30 <= nums[i] <= 30
     * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
     * <p>
     * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];
        int[] end = new int[len];
        pre[0] = nums[0];
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }
        end[0] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            end[len - 1 - i] = end[len - i - 2] * nums[i];
        }

        int[] ans = new int[len];
        ans[0] = end[len - 2];
        ans[len - 1] = pre[len - 2];
        for (int i = 1; i < len - 1; i++) {
            ans[i] = pre[i - 1] * end[len - 2 - i];
        }
        return ans;
    }
}
