package com.fewbug.erodebytes.leetcode.h100.h60_80;

import com.fewbug.erodebytes.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/19 12:24
 **/
public class H075 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode top = queue.poll();
                if (top != null) {
                    sb.append(top.val + ",");
                    queue.add(top.left);
                    queue.add(top.right);
                } else {
                    sb.append("null,");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data)) {
                return null;
            }
            String[] arr = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode top = queue.poll();
                if (!arr[index].equals("null")) {
                    top.left = new TreeNode(Integer.parseInt(arr[index]));
                    queue.add(top.left);
                }
                index++;
                if (!arr[index].equals("null")) {
                    top.right = new TreeNode(Integer.parseInt(arr[index]));
                    queue.add(top.right);
                }
                index++;
            }
            return root;
        }
    }
}
