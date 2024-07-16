package com.fewbug.erodebytes.leetcode.h100.h40_60;

import com.fewbug.erodebytes.datastruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/15 22:52
 **/
public class H043 {

    /**
     * 提示:
     * <p>
     * 1 <= preorder.length <= 3000
     * inorder.length == preorder.length
     * -3000 <= preorder[i], inorder[i] <= 3000
     * preorder 和 inorder 均 无重复 元素
     * inorder 均出现在 preorder
     * preorder 保证 为二叉树的前序遍历序列
     * inorder 保证 为二叉树的中序遍历序列
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, map, 0, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> map, int preOrderIndex, int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd) {
        if (preOrderStart == preOrderEnd) {
            return new TreeNode(preorder[preOrderIndex]);
        }

        TreeNode node = new TreeNode(preorder[preOrderIndex]);
        int inorderIndex = map.get(preorder[preOrderIndex]);

        int leftNum = inorderIndex - inOrderStart;
        int rightNum = inOrderEnd - inorderIndex;

        if (leftNum > 0) {
            node.left = buildTree(preorder, inorder, map, preOrderIndex + 1, preOrderStart + 1, preOrderIndex + leftNum, inOrderStart, inorderIndex - 1);
        }
        if (rightNum > 0) {
            node.right = buildTree(preorder, inorder, map, preOrderIndex + leftNum + 1, preOrderIndex + leftNum + 1, preOrderEnd, inorderIndex + 1, inOrderEnd);
        }
        return node;
    }
}
