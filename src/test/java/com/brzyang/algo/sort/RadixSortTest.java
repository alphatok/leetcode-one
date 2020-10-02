package com.brzyang.algo.sort;

import com.algo.sort.RadixSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RadixSortTest {

    @Test
    public void sortAsc() {
        RadixSort sort = new RadixSort();
        assertArrayEquals(new int[]{}, sort.sortAsc(new int[]{}));
        assertArrayEquals(new int[]{1,1,3}, sort.sortAsc(new int[]{1,3,1}));
        assertArrayEquals(new int[]{1,1,1,2,3}, sort.sortAsc(new int[]{1,3,1,1,2}));
        assertArrayEquals(new int[]{-1,-1,1,2,3}, sort.sortAsc(new int[]{1,3,-1,-1,2}));
        assertArrayEquals(new int[]{1,2,3,20,100}, sort.sortAsc(new int[]{1,3,100,20,2}));
        assertArrayEquals(new int[]{-100,-22,-1, 1,2,3}, sort.sortAsc(new int[]{1,3,-100,-22,2, -1}));
        assertArrayEquals(new int[]{-100,-22,-1,}, sort.sortAsc(new int[]{-100,-22, -1}));
        new SortTestUtil().testAsc(sort);
    }
}