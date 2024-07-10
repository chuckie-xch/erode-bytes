package com.fewbug.erodebytes.leetcode.h100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/9 14:53
 **/
public class H002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode head = null, tail = null;
        int carry = 0;
        while (first != null || second != null) {
            int firstVal = first == null ? 0 : first.val;
            int secondVal = second == null ? 0 : second.val;
            int sum = firstVal + secondVal + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (head == null) {
                head = tail = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    private ListNode reverseNode(ListNode root) {
        ListNode pre = null;
        ListNode cur = root;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;

        }

        return pre;
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
