package com.fewbug.erodebytes.leetcode.topic.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

import com.fewbug.erodebytes.datastruct.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/23 11:26
 **/
public class Day06 {

    /**
     * 提示：
     *
     * 链表中结点的数目为 sz <br>
     * 1 <= sz <= 30 <br>
     * 0 <= Node.val <= 100 <br>
     * 1 <= n <= sz <br>
     * 
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        Deque<ListNode> st = new ArrayDeque<>();
        while (cur != null) {
            st.push(cur);
            cur = cur.next;
        }
        int cnt = 0;
        ListNode pre = dummy;
        while (!st.isEmpty() && cnt <= n) {
            pre = st.pop();
            cnt++;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    public ListNode solution2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy, right = dummy;
        while (n > 0) {
            right = right.next;
            n--;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
