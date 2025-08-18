package com.fewbug.erodebytes.leetcode.weeklycontest.w450;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/7/2 10:24
 **/
public class Q02 {

    class UnionFind {
        private final int[] parent;
        private int n;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            this.n = n;
        }

        private int find(int x) {
            int p = parent[x];
            if (p != x) {
                return find(p);
            }
            return x;
        }

        private void merge(int from, int to) {
            int x = find(from);
            int y = find(to);
            if (x == y) {
                return;
            }

            parent[x] = y;
            n--;
        }
    }


    /**
     * 提示:
     *
     * 1 <= nums.length <= 105 <br>
     * 1 <= nums[i] <= 109 <br>
     * nums 由 互不相同 的正整数组成。 <br>
     * 
     * @param nums
     * @return
     */
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int res = 0;
            while (x > 0) {
                res += x % 10;
                x = x / 10;
            }
            arr[i][0] = res;
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            uf.merge(arr[i][2], i);
        }
        return n - uf.n;
    }
}
