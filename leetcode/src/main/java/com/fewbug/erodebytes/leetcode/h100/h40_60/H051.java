package com.fewbug.erodebytes.leetcode.h100.h40_60;

import com.fewbug.erodebytes.datastruct.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/16 15:29
 **/
public class H051 {

    /**
     * 提示：
     * <p>
     * 链表中节点的数目范围在范围 [0, 104] 内
     * -105 <= Node.val <= 105
     * pos 的值为 -1 或者链表中的一个有效索引
     * <p>
     * 进阶：你是否可以使用 O(1) 空间解决此题？
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }

        return null;
    }
}
