package com.brzyang.algo.sort;

import com.algo.sort.BubbleSort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sortAsc() {
        new SortTestUtil().testAsc(new BubbleSort());
    }

    @Test
    public void sortDesc() {
        new SortTestUtil().testDesc(new BubbleSort());
    }
}