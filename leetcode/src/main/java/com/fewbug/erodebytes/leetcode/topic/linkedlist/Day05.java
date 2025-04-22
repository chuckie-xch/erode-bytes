package com.fewbug.erodebytes.leetcode.topic.linkedlist;

import com.fewbug.erodebytes.datastruct.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/22 09:52
 **/
public class Day05 {

    /**
     * 提示：
     *
     * 链表中节点数目在范围[1, 105] 内 <br>
     * 0 <= Node.val <= 9
     * 
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMiddle(head);
        ListNode head2 = reverseList(mid);
        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head2 = head2.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode mid) {
        ListNode pre = null;
        while (mid != null) {
            ListNode next = mid.next;
            mid.next = pre;
            pre = mid;
            mid = next;
        }
        return pre;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
