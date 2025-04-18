package com.fewbug.erodebytes.leetcode.topic.linkedlist;

import com.fewbug.erodebytes.datastruct.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/18 11:16
 **/
public class Day03 {

    /**
     * 提示：
     *
     * 链表中节点数目为 n <br>
     * 1 <= n <= 500 <br>
     * -500 <= Node.val <= 500 <br>
     * 1 <= left <= right <= n <br>
     * 
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode pre = null;
        ListNode p1 = p0.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = p1.next;
            p1.next = pre;
            pre = p1;
            p1 = next;
        }
        p0.next.next = p1;
        p0.next = pre;
        return dummy.next;
    }
}
