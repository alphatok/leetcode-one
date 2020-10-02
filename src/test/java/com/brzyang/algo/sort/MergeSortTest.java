package com.brzyang.algo.sort;

import com.algo.sort.MergeSortRecursive;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void sortAsc() {
        new SortTestUtil().testAsc(new MergeSortRecursive());

    }

    @Test
    public void sortDesc() {
        new SortTestUtil().testDesc(new MergeSortRecursive());
    }
}