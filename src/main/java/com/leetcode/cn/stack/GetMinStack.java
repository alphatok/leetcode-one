package com.leetcode.cn.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GetMinStack {
    public static class Solution {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        /**
         * return a array which include all ans for op3
         * @param op int整型二维数组 operator
         * @return int整型一维数组
         */
        public int[] getMinStack (int[][] op) {
            List<Integer> rs = new ArrayList<>();
            for (int i = 0; i < op.length; i++){
                int[] opr = op[i];
                if (opr[0] == 1 ){
                    // push
                    push(opr[1]);
                }else if (opr[0] == 2){
                    pop();
                }else{
                    // opr[0] == 2 getMin
                    rs.add(getMin());
                }
            }

            int[] ret = new int[rs.size()];
            for (int i = 0; i < rs.size(); i++){
                ret[i] = rs.get(i);
            }

            return ret;
        }

        public void push(int val){
            stack.push(val);
            if (minStack.isEmpty()){
                minStack.push(val);
            }else{
                int currentMin = minStack.peek();
                if (val < currentMin){
                    minStack.push(val);
                }else{
                    minStack.push(currentMin);
                }
            }
        }

        public int pop(){
            minStack.pop();
            return stack.pop();
        }

        public int getMin(){
            return minStack.peek();
        }
    }
}
