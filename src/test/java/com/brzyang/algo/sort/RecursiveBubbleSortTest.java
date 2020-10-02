package com.brzyang.algo.sort;

import com.algo.sort.BubbleSortRecursive;
import org.junit.Test;

public class RecursiveBubbleSortTest {

    @Test
    public void sortAsc() {
        new SortTestUtil().testAsc(new BubbleSortRecursive());
    }
}