package com.fewbug.erodebytes.leetcode.h100.h40_60;

import com.fewbug.erodebytes.datastruct.TreeNode;

import java.util.*;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/15 22:13
 **/
public class H041 {


    /**
     * 提示：
     * <p>
     * 树中节点数目在范围 [0, 2000] 内
     * -1000 <= Node.val <= 1000
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
            }
            res.add(list);
        }
        return res;
    }


}
