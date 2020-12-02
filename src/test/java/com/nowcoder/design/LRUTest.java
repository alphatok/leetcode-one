package com.nowcoder.design;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUTest {

    @Test
    public void test(){
        LRU.Solution solution = new LRU.Solution();
        int[][] input = new int[6][3];
        input[0] = new int[]{1,1,1};
        input[1] = new int[]{1,2,2};
        input[2] = new int[]{1,3,2};
        input[3] = new int[]{2,1};
        input[4] = new int[]{1,4,4};
        input[5] = new int[]{2,2};
        int[] result = solution.LRU(input, 3);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }
}