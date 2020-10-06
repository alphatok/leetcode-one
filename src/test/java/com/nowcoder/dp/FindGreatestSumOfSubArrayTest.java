package com.nowcoder.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindGreatestSumOfSubArrayTest {
    @Test
    public void test(){
        FindGreatestSumOfSubArray.Solution solution = new FindGreatestSumOfSubArray.Solution();
        assertEquals(1, solution.FindGreatestSumOfSubArray(new int[]{1}));
        assertEquals(4, solution.FindGreatestSumOfSubArray(new int[]{1,0,3}));
        assertEquals(3, solution.FindGreatestSumOfSubArray(new int[]{1,-1,3}));
        assertEquals(8, solution.FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2}));
        assertEquals(6, solution.FindGreatestSumOfSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}