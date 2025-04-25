package com.fewbug.erodebytes.leetcode.topic.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.fewbug.erodebytes.datastruct.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/24 09:21
 **/
public class Q01 {

    /**
     * 提示：
     *
     * 树中节点数目在范围 [0, 100] 内 <br>
     * -100 <= Node.val <= 100 <br>
     * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
     * 
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        Deque<TreeNode> st = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            st.push(root);
        }
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            list.add(node.val);
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
        }
        return list;
    }
}
