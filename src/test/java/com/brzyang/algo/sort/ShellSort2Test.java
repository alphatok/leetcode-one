package com.brzyang.algo.sort;

import com.algo.sort.ShellSort2;
import org.junit.Test;

public class ShellSort2Test {

    @Test
    public void sortAsc() {
        new SortTestUtil().testAsc(new ShellSort2());
    }

    @Test
    public void sortDesc() {
        new SortTestUtil().testDesc(new ShellSort2());
    }
}