package com.fewbug.erodebytes.leetcode.h100.h40_60;

import com.fewbug.erodebytes.datastruct.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/16 23:38
 **/
public class H056 {

    /**
     * 提示：
     * <p>
     * listA 中节点数目为 m
     * listB 中节点数目为 n
     * 1 <= m, n <= 3 * 104
     * 1 <= Node.val <= 105
     * 0 <= skipA <= m
     * 0 <= skipB <= n
     * 如果 listA 和 listB 没有交点，intersectVal 为 0
     * 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
     * <p>
     * 进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }
        ListNode p = headA, q = headB;
        while (p != null && q != null) {
            if (q == p) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        if (p == null && q == null) {
            return null;
        }
        ListNode slowNode = p == null ? q : p;
        ListNode fastNode = p == null ? headA : headB;
        ListNode slowResetNode = fastNode == headA ? headB : headA;

        int count = 0;
        while (slowNode != null) {
            slowNode = slowNode.next;
            count++;
        }
        slowNode = slowResetNode;
        while (count > 0) {
            slowNode = slowNode.next;
            count--;
        }

        while (slowNode != null && fastNode != null) {
            if (slowNode == fastNode) {
                return slowNode;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        return null;

    }

    public ListNode solution1(ListNode headA, ListNode headB) {
        int aLen = getLength(headA);
        int bLen = getLength(headB);
        int step = aLen > bLen ? aLen - bLen : bLen - aLen;
        if (step > 0) {
            ListNode first = aLen > bLen ? headA : headB;
            ListNode second = first == headA ? headB : headA;
            while (step > 0) {
                first = first.next;
                step--;
            }
            while (first != null && second != null) {
                if (first == second) {
                    return first;
                }
                first = first.next;
                second = second.next;
            }
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != null && pB != null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }

    private int getLength(ListNode root) {
        int res = 0;
        ListNode tail = root;
        while (tail != null) {
            tail = tail.next;
            res++;
        }
        return res;
    }

}
