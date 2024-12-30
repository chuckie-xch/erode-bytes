package com.fewbug.erodebytes.leetcode.daily.year24.m12;

import com.fewbug.erodebytes.datastruct.ListNode;
import com.fewbug.erodebytes.datastruct.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/12/30 09:11
 **/
public class Day030 {

    /**
     * 提示：
     *
     * 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
     * 链表包含的节点数目在 1 到 100 之间。
     * 二叉树包含的节点数目在 1 到 2500 之间。
     * @param head
     * @param root
     * @return
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode tail,TreeNode root) {
        if (tail == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val == tail.val) {
            return dfs(tail.next, root.left) || dfs(tail.next, root.right);
        }
        return false;
    }


}
