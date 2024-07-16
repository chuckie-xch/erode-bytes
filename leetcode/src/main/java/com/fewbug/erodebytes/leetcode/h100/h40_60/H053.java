package com.fewbug.erodebytes.leetcode.h100.h40_60;

import com.fewbug.erodebytes.datastruct.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/16 18:58
 **/
public class H053 {

    /**
     * 提示：
     * <p>
     * 链表中节点的数目在范围 [0, 5 * 104] 内
     * -105 <= Node.val <= 105
     * <p>
     * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return sortSolution(head, null);
    }

    private ListNode sortSolution(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        return mergeNode(sortSolution(head, mid), sortSolution(mid, tail));
    }

    private ListNode mergeNode(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null || listNode2 == null) {
            return listNode1 == null ? listNode2 : listNode1;
        }
        ListNode p1 = listNode1;
        ListNode p2 = listNode2;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        tail.next = p1 == null ? p2 : p1;
        return dummy.next;
    }
}
