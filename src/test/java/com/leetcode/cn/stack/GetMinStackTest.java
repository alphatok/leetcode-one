package com.leetcode.cn.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetMinStackTest {

    @Test
    public void testGetMinStack(){
        GetMinStack.Solution solution = new GetMinStack.Solution();
        int[][] op = new int[6][2];
        op[0] = new int[]{1,3};
        op[1] = new int[]{1,2};
        op[2] = new int[]{1,1};
        op[3] = new int[]{3};
        op[4] = new int[]{2};
        op[5] = new int[]{3};
        int[] result = solution.getMinStack(op);
        assertArrayEquals(new int[]{1,2}, result);
    }

}