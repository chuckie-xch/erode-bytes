package com.fewbug.erodebytes.leetcode.h100.h80_100;

import com.fewbug.erodebytes.datastruct.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/20 14:27
 **/
public class H081 {

    /**
     * 提示：
     * <p>
     * 树的节点数在 [1, 104] 范围内
     * 0 <= Node.val <= 104
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        return process(root).ans;
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, 0, 0);
        }
        Info left = process(root.left);
        Info right = process(root.right);
        int chooseRes = left.notChooseRes + right.notChooseRes + root.val;
        int noChooseRes = left.ans + right.ans;
        int ans = Math.max(chooseRes, noChooseRes);
        return new Info(chooseRes, noChooseRes, ans);
    }

    public class Info {
        int chooseRes;
        int notChooseRes;
        int ans;

        public Info(int chooseRes, int notChooseRes, int ans) {
            this.chooseRes = chooseRes;
            this.notChooseRes = notChooseRes;
            this.ans = ans;
        }
    }
}
