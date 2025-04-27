package com.fewbug.erodebytes.leetcode.topic.binarytree;

import com.fewbug.erodebytes.datastruct.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/27 11:03
 **/
public class Q04 {

    /**
     * 提示：
     *
     * 树中节点的数量在 [0, 104] 区间内。<br>
     * -100 <= Node.val <= 100
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
