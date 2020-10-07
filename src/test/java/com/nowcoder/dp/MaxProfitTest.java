package com.nowcoder.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProfitTest {
    @Test
    public void test(){
        BestTimeBuySellStock.Solution solution = new BestTimeBuySellStock.Solution();
        assertEquals(5, solution.maxProfit(new int[]{7,1,5,3,4,6}));
        assertEquals(3, solution.maxProfit(new int[]{1,4,2}));
        assertEquals(2, solution.maxProfit(new int[]{2,4,1}));
        assertEquals(0, solution.maxProfit(new int[]{7,6,4,3,2,1}));
        assertEquals(1, solution.maxProfit(new int[]{3,2,3,1,2}));
    }

    @Test
    public void test2(){
        BestTimeBuySellStock.Solution solution = new BestTimeBuySellStock.Solution();
        assertEquals(5, solution.maxProfit2(new int[]{7,1,5,3,4,6}));
        assertEquals(3, solution.maxProfit2(new int[]{1,4,2}));
        assertEquals(2, solution.maxProfit2(new int[]{2,4,1}));
        assertEquals(0, solution.maxProfit2(new int[]{7,6,4,3,2,1}));
        assertEquals(1, solution.maxProfit2(new int[]{3,2,3,1,2}));
    }
}