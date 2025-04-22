package com.fewbug.erodebytes.leetcode.topic.linkedlist;

import com.fewbug.erodebytes.datastruct.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/21 09:16
 **/
public class Day04 {

    /**
     * 提示：
     *
     * 链表的结点数范围是 [1, 100] <br>
     * 1 <= Node.val <= 100
     * 
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
