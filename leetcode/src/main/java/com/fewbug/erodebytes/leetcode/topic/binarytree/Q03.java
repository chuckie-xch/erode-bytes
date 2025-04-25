package com.fewbug.erodebytes.leetcode.topic.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.fewbug.erodebytes.datastruct.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/24 10:53
 **/
public class Q03 {

    /**
     * 提示：
     *
     * 树中节点的数目在范围 [0, 100] 内 <br>
     * -100 <= Node.val <= 100 <br>
     * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
     * 
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                if (root.left != null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            root = st.pop();
            res.add(root.val);
            if (!st.isEmpty() && st.peek().left == root) {
                root = st.peek().right;
            } else {
                root = null;
            }
        }

        return res;
    }
}
