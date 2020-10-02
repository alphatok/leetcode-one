package com.brzyang.algo.sort;

import com.algo.sort.QuickSortRandom;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortRandomTest {

    @Test
    public void sortAsc() {
        QuickSortRandom sort = new QuickSortRandom();
        assertArrayEquals(new int[]{}, sort.sortAsc(new int[]{}));
        assertArrayEquals(new int[]{1,1,3}, sort.sortAsc(new int[]{1,3,1}));
        assertArrayEquals(new int[]{1,1,1,2,3}, sort.sortAsc(new int[]{1,3,1,1,2}));
        new SortTestUtil().testAsc(sort);
    }
}