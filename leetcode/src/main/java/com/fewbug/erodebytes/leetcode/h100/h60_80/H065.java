package com.fewbug.erodebytes.leetcode.h100.h60_80;

import com.fewbug.erodebytes.datastruct.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/18 00:10
 **/
public class H065 {

    public TreeNode invertTree(TreeNode root) {
        TreeNode tail = root;
        doInvert(tail);
        return root;
    }

    public void doInvert(TreeNode tail) {
        if (tail == null) {
            return;
        }
        TreeNode left = tail.left;
        TreeNode right = tail.right;
        doInvert(left);
        doInvert(right);
        tail.right = left;
        tail.left = right;
    }
}
