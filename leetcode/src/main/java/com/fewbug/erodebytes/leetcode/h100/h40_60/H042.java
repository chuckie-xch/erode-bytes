package com.fewbug.erodebytes.leetcode.h100.h40_60;

import com.fewbug.erodebytes.datastruct.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/15 22:47
 **/
public class H042 {

    /**
     * 提示：
     * <p>
     * 树中节点的数量在 [0, 104] 区间内。
     * -100 <= Node.val <= 100
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
