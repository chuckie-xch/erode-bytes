package com.fewbug.erodebytes.leetcode.h100.h40_60;

import com.fewbug.erodebytes.datastruct.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/17 01:58
 **/
public class H060 {

    /**
     * 提示：
     * <p>
     * 链表中节点的数目范围是 [0, 5000]
     * -5000 <= Node.val <= 5000
     * <p>
     * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        ListNode pre = null;
        while (tail != null) {
            ListNode next = tail.next;
            tail.next = pre;
            pre = tail;
            tail = next;
        }
        return pre;
    }
}
