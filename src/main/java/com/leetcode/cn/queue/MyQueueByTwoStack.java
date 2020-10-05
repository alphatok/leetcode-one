package com.leetcode.cn.queue;

import java.util.Stack;

public class MyQueueByTwoStack {

    public static class Solution0 {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            stack1.push(node);

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        public int pop() {
            return stack2.pop();
        }
    }


    public static class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            // stack1 empty
            stack1.addAll(stack2); // queue ops
            stack2.clear();

            stack2.push(node);
            stack2.addAll(stack1);

            // cleared to accept new node
            stack1.clear();
        }

        public int pop() {
            return stack2.pop();
        }
    }

    public static class Solution2 {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
           stack1.push(node);
        }

        public int pop() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }else{
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }
}
