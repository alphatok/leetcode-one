package com.brzyang.algo.sort;

import com.algo.sort.ShellSort;
import org.junit.Test;

public class ShellSortTest {

    @Test
    public void sortAsc() {
        new SortTestUtil().testAsc(new ShellSort());

    }

    @Test
    public void sortDesc() {
        new SortTestUtil().testDesc(new ShellSort());
    }
}