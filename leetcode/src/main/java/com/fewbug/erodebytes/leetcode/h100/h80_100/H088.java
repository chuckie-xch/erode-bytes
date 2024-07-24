package com.fewbug.erodebytes.leetcode.h100.h80_100;

import com.fewbug.erodebytes.datastruct.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/24 16:01
 **/
public class H088 {

    /**
     * 提示:
     * <p>
     * 二叉树的节点个数的范围是 [0,1000]
     * -109 <= Node.val <= 109
     * -1000 <= targetSum <= 1000
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        ans += dfs(root, targetSum);
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }

    private int dfs(TreeNode root, long targetSum) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            ans++;
        }
        ans += dfs(root.left, targetSum - root.val);
        ans += dfs(root.right, targetSum - root.val);
        return ans;
    }
}
