package com.brzyang.algo.sort;


import com.algo.sort.HeapSort;
import com.algo.sort.HeapSort2;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BubbleSortTest.class,
        SelectionSortTest.class,
        RecursiveBubbleSortTest.class,
        ShellSort2Test.class,
        InsertionSortTest.class,
        ShellSortTest.class,
        MergeSortTest.class,
        MergeSortInPlaceRecursiveTest.class,
        MergeSortRecursiveInPlaceUsingInsertionTest.class,
        QuickSortTest.class,
        QuickSortRandomTest.class,
        CountingSortTest.class,
        RadixSortTest.class,
        BucketSortTest.class,
        HeapSort.class,
        HeapSort2.class,

        // 接着写其他被测单元测试类
})

public class SortSuiteTest extends TestCase {

}


