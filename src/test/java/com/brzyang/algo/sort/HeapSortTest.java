package com.brzyang.algo.sort;

import com.algo.sort.BubbleSort;
import com.algo.sort.HeapSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class HeapSortTest {

    @Test
    public void sortAsc() {
        HeapSort sort = new HeapSort();
//        assertArrayEquals(new int[]{-9,0,2,3,4,5,45,56,2937}, sort.sortAsc(new int[]{0,3,45,2,4,5,56,2937,-9}));
        int[] arr = {-51448, -37202, -10523, -87281, -29391, -3708,
                -88749, -62718, -83811, -11445, -25893, -46486, -64124, -33133, -77766, -78676, -10004, -95161,
                -62625, -87068, -47661, -77630, -96848, -43814, -62675, -64503, -5815, -98990, -52919, -3620,
                -26001, -63273, -90086, -61349, -39309, -37007, -43321, -81641, -5641, -7930, -43495, -84246, -84744};
        int[] newArr = Arrays.copyOf(arr, arr.length);
        new BubbleSort().sortAsc(arr);
        assertArrayEquals(arr, sort.sortAsc(newArr));
        new SortTestUtil().testAsc(sort);
    }
}