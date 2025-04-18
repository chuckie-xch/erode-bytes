package com.fewbug.erodebytes.leetcode.topic.linkedlist;

import com.fewbug.erodebytes.datastruct.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/4/18 09:36
 **/
public class Day01 {

    /**
     * 提示：
     *
     * 链表不为空。 <br>
     * 链表的结点总数不超过 30。 <br>
     * 每个结点的值不是 0 就是 1。<br>
     * 
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        Deque<Integer> st = new ArrayDeque<>();
        while (head != null) {
            st.push(head.val);
            head = head.next;
        }
        int i = 0;
        double ans = 0;
        while (!st.isEmpty()) {
            ans += Math.pow(2, i++) * st.pop();
        }
        return (int)ans;
    }

    public int solution(ListNode head) {
        head = reverse(head);
        int i = 0;
        double ans = 0;
        while (head != null) {
            ans += Math.pow(2, i++) * head.val;
            head = head.next;
        }
        return (int)ans;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
