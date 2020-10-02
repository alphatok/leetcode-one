package com.brzyang.algo.sort;

import com.algo.sort.QuickSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void sortAsc() {
        QuickSort sort = new QuickSort();
        assertArrayEquals(new int[]{}, sort.sortAsc(new int[]{}));
        assertArrayEquals(new int[]{1,1,3}, sort.sortAsc(new int[]{1,3,1}));
        assertArrayEquals(new int[]{1,1,1,2,3}, sort.sortAsc(new int[]{1,3,1,1,2}));
        new SortTestUtil().testAsc(sort);
    }

    @Test
    public void sortDesc() {
        QuickSort sort = new QuickSort();
        assertArrayEquals(new int[]{}, sort.sortDesc(new int[]{}));
        assertArrayEquals(new int[]{3,2,1, 1,1}, sort.sortDesc(new int[]{1,3,1,1,2}));
        assertArrayEquals(new int[]{3,1,1}, sort.sortDesc(new int[]{1,3,1}));
        new SortTestUtil().testAsc(sort);
    }
}