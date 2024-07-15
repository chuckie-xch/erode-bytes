package com.fewbug.erodebytes.leetcode.h100.h20_40;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/15 16:19
 **/
public class H039 {

    /**
     * 提示：
     * <p>
     * 树中节点数目范围在[1, 104] 内
     * -231 <= Node.val <= 231 - 1
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root).valid;
    }

    private Info dfs(TreeNode root) {

        if (root == null) {
            return null;
        }

        Info left = dfs(root.left);
        Info right = dfs(root.right);

        int curVal = root.val;
        if (left == null && right == null) {
            return new Info(curVal, curVal, true);
        } else if (left == null && right != null) {
            int minVal = Math.min(curVal, right.min);
            int maxVal = Math.max(curVal, right.max);
            boolean isValid = right.valid && right.min > curVal;
            return new Info(minVal, maxVal, isValid);
        } else if (left != null && right == null) {
            int minVal = Math.min(curVal, left.min);
            int maxVal = Math.max(curVal, left.max);
            boolean isValid = left.valid && left.max < curVal;
            return new Info(minVal, maxVal, isValid);
        } else {
            int minVal = Math.min(Math.min(curVal, left.min), right.min);
            int maxVal = Math.max(Math.max(curVal, left.max), right.max);
            boolean isValid = left.valid && right.valid && left.max < curVal && right.min > curVal;
            return new Info(minVal, maxVal, isValid);
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

    public class Info {
        int min;
        int max;
        boolean valid;

        public Info(int min, int max, boolean valid) {
            this.min = min;
            this.max = max;
            this.valid = valid;
        }
    }
}
