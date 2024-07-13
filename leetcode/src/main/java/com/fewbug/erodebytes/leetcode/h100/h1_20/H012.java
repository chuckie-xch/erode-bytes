package com.fewbug.erodebytes.leetcode.h100.h1_20;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/10 21:52
 **/
public class H012 {

    /**
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     *
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first = list1;
        ListNode second = list2;
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }
        while (first != null) {
            tail.next = first;
            first = first.next;
            tail = tail.next;
        }
        while (second != null) {
            tail.next = second;
            second = second.next;
            tail = tail.next;
        }
        return dummy.next;
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
