package com.brzyang.algo.sort;

import com.algo.sort.MergeSortInPlaceRecursive;
import org.junit.Test;

public class MergeSortInPlaceRecursiveTest {

    @Test
    public void sortAsc() {
        new SortTestUtil().testAsc(new MergeSortInPlaceRecursive());
    }
}