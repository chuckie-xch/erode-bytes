package com.fewbug.erodebytes.leetcode.topic.slidingwindow;

import java.util.*;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/2/28 09:40
 **/
public class Q13 {

    /**
     * 3 <= nums.length <= 3000 <br>
     * -105 <= nums[i] <= 105
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) {
                continue;
            }
            if (x + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if (x + nums[n - 1] + nums[n - 2] < 0) {
                continue;
            }

            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = x + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    ans.add(List.of(x, nums[l], nums[r]));
                    for (l++; l < r && nums[l] == nums[l - 1]; l++) {

                    }
                    for (r--; l < r && nums[r] == nums[r + 1]; r--) {

                    }
                }
            }
        }

        return ans;
    }
}
