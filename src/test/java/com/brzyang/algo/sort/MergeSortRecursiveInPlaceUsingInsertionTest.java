package com.brzyang.algo.sort;

import com.algo.sort.MergeSortRecursiveInPlaceUsingInsertion;
import org.junit.Test;

public class MergeSortRecursiveInPlaceUsingInsertionTest {

    @Test
    public void sortAsc() {
        new SortTestUtil().testAsc(new MergeSortRecursiveInPlaceUsingInsertion());
    }

    @Test
    public void sortDesc() {
        new SortTestUtil().testDesc(new MergeSortRecursiveInPlaceUsingInsertion());
    }
}