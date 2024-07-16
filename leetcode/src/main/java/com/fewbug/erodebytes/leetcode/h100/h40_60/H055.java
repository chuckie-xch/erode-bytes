package com.fewbug.erodebytes.leetcode.h100.h40_60;

import java.util.Stack;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/16 21:54
 **/
public class H055 {

    class MinStack {

        private Stack<Integer> data;

        private Stack<Integer> helper;

        public MinStack() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        public void push(int val) {
            data.push(val);
            if (helper.isEmpty() || val <= helper.peek()) {
                helper.push(val);
            } else {
                helper.push(helper.peek());
            }
        }

        public void pop() {
            if (!data.isEmpty()) {
                data.pop();
                helper.pop();
            }
        }

        public int top() {
            if (!data.isEmpty()) {
                return data.peek();
            }
            throw new RuntimeException("非法操作，栈为空");
        }

        public int getMin() {
            if (!helper.isEmpty()) {
                return helper.peek();
            }
            throw new RuntimeException("非法操作，栈为空");
        }
    }
}
