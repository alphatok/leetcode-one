package com.algo.sort;

import com.alphatok.util.CollectionUtil;

import java.util.Arrays;

/**
 * using extra large space
 */
public class MergeSortRecursive implements AscSortInterface, DescSortInterface {

    @Override
    public int[] sortAsc(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = sortAsc(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sortAsc(Arrays.copyOfRange(arr, mid, arr.length));
        return CollectionUtil.mergeAsc(left, right);
    }

    @Override
    public int[] sortDesc(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = sortDesc(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sortDesc(Arrays.copyOfRange(arr, mid, arr.length));
        return CollectionUtil.mergeDesc(left, right);
    }

}
