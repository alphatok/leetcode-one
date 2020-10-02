package com.brzyang.algo.sort;

import com.algo.sort.BucketSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BucketSortTest {

    @Test
    public void sortAsc() {
        BucketSort sort = new BucketSort();
        assertArrayEquals(new int[]{}, sort.sortAsc(new int[]{}));
        assertArrayEquals(new int[]{1}, sort.sortAsc(new int[]{1}));
        assertArrayEquals(new int[]{1,2}, sort.sortAsc(new int[]{2,1}));
        assertArrayEquals(new int[]{-1,0,1,1,2}, sort.sortAsc(new int[]{2,1,1,0,-1}));
        assertArrayEquals(new int[]{-1,0,1,1,20}, sort.sortAsc(new int[]{20,1,1,0,-1}));
        new SortTestUtil().testAsc(sort);
    }
}