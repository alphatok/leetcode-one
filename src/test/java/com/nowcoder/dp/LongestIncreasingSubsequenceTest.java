package com.nowcoder.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void test(){
        LongestIncreasingSubsequence.Solution solution = new LongestIncreasingSubsequence.Solution();
        assertArrayEquals(new int[]{1,3,4,8,9}, solution.LIS(new int[]{2,1,5,3,6,4,8,9,7}));
        assertArrayEquals(new int[]{1,2,4}, solution.LIS(new int[]{1,2,8,6,4}));
        assertArrayEquals(new int[]{1,2,4,6,7,8}, solution.LIS(new int[]{1,3,5,2,4,6,7,8}));
        assertArrayEquals(new int[]{2,3,5,6}, solution.LIS(new int[]{4,2,3,1,5,6}));
    }

}