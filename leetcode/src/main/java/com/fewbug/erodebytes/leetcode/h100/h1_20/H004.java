package com.fewbug.erodebytes.leetcode.h100.h1_20;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/9 20:27
 **/
public class H004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int pre = m != 0 ? nums1[0] : nums2[0];
        int cur = pre;

        int middle = (m + n) / 2;
        boolean odd = (m + n) % 2 != 0;

        int l = 0, r = 0;
        int i = 0;
        while (l < m && r < n && i <= middle) {
            if (nums1[l] <= nums2[r]) {
                if (i != middle) {
                    pre = nums1[l];
                }
                cur = nums1[l];
                l++;
            } else {
                if (i != middle) {
                    pre = nums2[r];
                }
                cur = nums2[r];
                r++;
            }
            i++;
        }
        while (l < m && i <= middle) {
            if (i != middle) {
                pre = nums1[l];
            }
            cur = nums1[l];
            l++;
            i++;
        }
        while (r < n && i <= middle) {
            if (i != middle) {
                pre = nums2[r];
            }
            cur = nums2[r];
            r++;
            i++;
        }
        if (odd) {
            return cur;
        } else {
            return (cur + pre) / 2.0;
        }

    }
}
