package com.fewbug.erodebytes.leetcode.h100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/11 15:46
 **/
public class H014 {

    /**
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        return mergeTwoNode(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    private ListNode mergeTwoNode(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null || listNode2 == null) {
            return listNode1 == null ? listNode2 : listNode1;
        }
        ListNode dummy = new ListNode();
        ListNode p1 = listNode1, p2 = listNode2, tail = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        if (p1 != null || p2 != null) {
            tail.next = p1 == null ? p2 : p1;
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
