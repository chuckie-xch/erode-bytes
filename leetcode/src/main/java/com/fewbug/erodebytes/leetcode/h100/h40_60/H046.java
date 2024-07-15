package com.fewbug.erodebytes.leetcode.h100.h40_60;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/14 11:56
 **/
public class H046 {

    int ans = Integer.MIN_VALUE;


    /**
     * 树中节点数目范围是 [1, 3 * 104]
     * -1000 <= Node.val <= 1000
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        return backTracing(root).max;
    }

    private Result backTracing(TreeNode root) {
        if (root == null) {
            return null;
        }
        Result leftResult = backTracing(root.left);
        Result rightResult = backTracing(root.right);
        int lMax = root.val + (leftResult == null ? 0 : Math.max(0, Math.max(leftResult.lMax, leftResult.rMax)));
        int rMax = root.val + (rightResult == null ? 0 : Math.max(0, Math.max(rightResult.lMax, rightResult.rMax)));
        int cur = lMax + rMax - root.val;
        int max = cur;
        if (leftResult != null) {
            max = Math.max(max, leftResult.max);
        }
        if (rightResult != null) {
            max = Math.max(max, rightResult.max);
        }
        return new Result(max, lMax, rMax);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lMax = Math.max(0, dfs(root.left));
        int rMax = Math.max(0, dfs(root.right));

        ans = Math.max(ans, root.val + lMax + rMax);

        return root.val + Math.max(lMax, rMax);
    }

    public class Result {
        int max;
        int lMax;
        int rMax;

        public Result(int max, int lMax, int rMax) {
            this.max = max;
            this.lMax = lMax;
            this.rMax = rMax;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
