package com.nowcoder.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class LowerBoundTest {

    @Test
    public void test(){
        LowerBound.Solution solution = new LowerBound.Solution();

        assertEquals(1, solution.lower_bound_(  0, new int[]{}));
        assertEquals(0, solution.lower_bound_(  1, new int[]{1}));
        assertEquals(0, solution.lower_bound_(  0, new int[]{1}));
        assertEquals(0, solution.lower_bound_(  0, new int[]{1,3}));
        assertEquals(0, solution.lower_bound_(  1, new int[]{1,3}));
        assertEquals(1, solution.lower_bound_(  3, new int[]{1,3}));
        assertEquals(3, solution.lower_bound_(  4, new int[]{1,3}));
        assertEquals(1, solution.lower_bound_(  3, new int[]{1,3,3,3,3,3}));

        assertEquals(1, solution.lower_bound_(  2, new int[]{1,2,2,2,2,2,10}));

        assertEquals(2, solution.lower_bound_(  5, new int[]{1,3,5,6}));
        assertEquals(1, solution.lower_bound_(  3, new int[]{1,3,5,6}));
        assertEquals(5, solution.lower_bound_(  7, new int[]{1,3,5,6}));
        assertEquals(0, solution.lower_bound_(  0, new int[]{1,3,5,6}));
        assertEquals(2, solution.lower_bound_(  4, new int[]{1,2,4,4,5}));


    }

}