package com.fewbug.erodebytes.leetcode.h100.h1_20;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/10 17:52
 **/
public class H010 {

    /**
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        ListNode first = dummy;
        int index = 0;
        while (index < n) {
            first = first.next;
            index++;
        }

        ListNode second = dummy;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return dummy.next;
    }

    public ListNode solution2(ListNode head, int n) {
        ListNode first = head;
        int i = 0;
        while (first != null) {
            i++;
            first = first.next;
        }
        int targetIndex = i - n;
        ListNode guard = new ListNode(0, head);
        i = 0;
        first = guard;
        while (i < targetIndex) {
            i++;
            first = first.next;
        }
        first.next = first.next.next;
        return guard.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
