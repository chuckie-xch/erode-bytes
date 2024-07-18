package com.fewbug.erodebytes.leetcode.h100.h60_80;

import com.fewbug.erodebytes.datastruct.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/18 09:36
 **/
public class H066 {

    /**
     * 提示：
     * <p>
     * 链表中节点数目在范围[1, 105] 内
     * 0 <= Node.val <= 9
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = revert(slow.next);
        ListNode second = dummy.next;
        while (first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    private ListNode revert(ListNode tail) {
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
