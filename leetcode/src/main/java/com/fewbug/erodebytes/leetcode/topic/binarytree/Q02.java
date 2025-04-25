package com.fewbug.erodebytes.leetcode.topic.binarytree;

import com.fewbug.erodebytes.datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/24 10:49
 **/
public class Q02 {

    /**
     * 提示：
     *
     * 树中节点数目在范围 [0, 100] 内 <br>
     * -100 <= Node.val <= 100 <br>
     * 
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        while (root != null || !st.isEmpty()) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                TreeNode node = st.pop();
                res.add(node.val);
                root = node.right;
            }
        }
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
