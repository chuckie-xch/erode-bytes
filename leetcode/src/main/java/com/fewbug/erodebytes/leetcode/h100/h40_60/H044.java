package com.fewbug.erodebytes.leetcode.h100.h40_60;

import com.fewbug.erodebytes.datastruct.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/16 02:32
 **/
public class H044 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
    }

    private Info dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info left = dfs(root.left);
        Info right = dfs(root.right);
        if (left == null && right == null) {
            return new Info(root, root);
        } else if (left != null && right != null) {
            left.tail.right = right.head;
            root.right = left.head;
            root.left = null;
            return new Info(root, right.tail);
        } else if (left != null && right == null) {
            root.right = left.head;
            root.left = null;
            return new Info(root, left.tail);
        } else {
            root.right = right.head;
            root.left = null;
            return new Info(root, right.tail);
        }
    }

    public class Info {
        TreeNode head;
        TreeNode tail;

        public Info(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }


}
