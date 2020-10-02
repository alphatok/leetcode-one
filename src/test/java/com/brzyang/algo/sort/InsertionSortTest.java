package com.brzyang.algo.sort;

import com.algo.sort.InsertionSort;
import org.junit.Test;

public class InsertionSortTest {

    @Test
    public void sortAsc() {
        new SortTestUtil().testAsc(new InsertionSort());
    }

    @Test
    public void sortDesc() {
        new SortTestUtil().testDesc(new InsertionSort());
    }
}