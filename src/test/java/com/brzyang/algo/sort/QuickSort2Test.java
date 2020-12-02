package com.brzyang.algo.sort;

import com.algo.sort.QuickSort;
import com.algo.sort.QuickSort2;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSort2Test {

    @Test
    public void sortAsc() {
        QuickSort2 sort = new QuickSort2();
//        sort.sortAsc(new int[]{3, 1, 5, 2, 7, 9, 3, 0});
        sort.sortAsc(new int[]{3, 1, 5, 2, 7, 9, 3, 0});
        assertArrayEquals(new int[]{}, sort.sortAsc(new int[]{}));
        assertArrayEquals(new int[]{1,1,3}, sort.sortAsc(new int[]{1,3,1}));
        assertArrayEquals(new int[]{1,1,1,2,3}, sort.sortAsc(new int[]{1,3,1,1,2}));
        new SortTestUtil().testAsc(sort);
    }
}