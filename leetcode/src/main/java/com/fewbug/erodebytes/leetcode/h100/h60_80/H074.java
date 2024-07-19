package com.fewbug.erodebytes.leetcode.h100.h60_80;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/19 10:58
 **/
public class H074 {

    /**
     * 提示：
     * <p>
     * 1 <= n <= 105
     * nums.length == n + 1
     * 1 <= nums[i] <= n
     * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
