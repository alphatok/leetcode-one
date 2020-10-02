package com.brzyang.algo.sort;

import com.algo.sort.SelectionSort;
import org.junit.Test;

public class SelectionSortTest {
    @Test
    public void testSortAsc(){
        new SortTestUtil().testAsc(new SelectionSort());
    }

    @Test
    public void testSortDesc(){
        new SortTestUtil().testDesc(new SelectionSort());
    }
}
