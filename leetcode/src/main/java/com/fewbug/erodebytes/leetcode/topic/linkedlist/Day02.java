package com.fewbug.erodebytes.leetcode.topic.linkedlist;

import com.fewbug.erodebytes.datastruct.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/18 10:42
 **/
public class Day02 {

    /**
     * 提示：
     *
     * 链表中节点的数目范围是 [0, 5000] <br>
     * -5000 <= Node.val <= 5000
     * 
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
