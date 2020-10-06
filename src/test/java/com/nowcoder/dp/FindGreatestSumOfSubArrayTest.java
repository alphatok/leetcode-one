package com.nowcoder.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindGreatestSumOfSubArrayTest {

    @Test
    public void testRecursive(){
        FindGreatestSumOfSubArray.Solution solution = new FindGreatestSumOfSubArray.Solution();
        assertEquals(1, solution.FindGreatestSumOfSubArray(new int[]{1}));
        assertEquals(4, solution.FindGreatestSumOfSubArray(new int[]{1,0,3}));
        assertEquals(3, solution.FindGreatestSumOfSubArray(new int[]{1,-1,3}));
        assertEquals(8, solution.FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2}));
        assertEquals(6, solution.FindGreatestSumOfSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        assertEquals(12, solution.FindGreatestSumOfSubArray(new int[]{1, -2, 3, 5, -2, 6, -1}));
    }

    @Test
    public void testForloop(){
        FindGreatestSumOfSubArray.Solution solution = new FindGreatestSumOfSubArray.Solution();
        assertEquals(1, solution.FindGreatestSumOfSubArray2(new int[]{1}));
        assertEquals(4, solution.FindGreatestSumOfSubArray2(new int[]{1,0,3}));
        assertEquals(8, solution.FindGreatestSumOfSubArray2(new int[]{6,-3,-2,7,-15,1,2,2}));
        assertEquals(3, solution.FindGreatestSumOfSubArray2(new int[]{1,-1,3}));
        assertEquals(6, solution.FindGreatestSumOfSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        assertEquals(12, solution.FindGreatestSumOfSubArray2(new int[]{1, -2, 3, 5, -2, 6, -1}));
    }
}