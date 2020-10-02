package com.algo.sort;

import com.alphatok.util.CollectionUtil;

public class QuickSort implements AscSortInterface, DescSortInterface {
    @Override
    public int[] sortAsc(int[] arr) {
        if (null == arr || arr.length <= 1){
            return arr;
        }

        sortAsc(arr, 0, arr.length - 1);

        return arr;
    }

    private void sortAsc(int[] arr, int fromInc, int toInc) {
        if (fromInc >= toInc) {
            return;
        }

        int pivot = partionAsc(arr, fromInc, toInc);
        sortAsc(arr, fromInc, pivot -1);
        sortAsc(arr, pivot + 1, toInc);
    }

    private int partionAsc(int[] arr, int fromInc, int toInc) {
        // {9, 0, 8, 10, -5, 2, 13, 7}
        // f                        b
        int val = arr[fromInc];
        int forwardIdx = fromInc, backwardIdx = toInc;
        // loop until meet
        while(forwardIdx < backwardIdx){
            // >= !!!! (when element equals
            while (forwardIdx < backwardIdx && arr[backwardIdx] >= val){
                backwardIdx--;
            }
            arr[forwardIdx] = arr[backwardIdx];

            while (forwardIdx < backwardIdx && arr[forwardIdx] <= val){
                forwardIdx++;
            }
            arr[backwardIdx] = arr[forwardIdx];
        }

        arr[backwardIdx] = val;

        return forwardIdx;
    }

    @Override
    public int[] sortDesc(int[] arr) {
        if (null == arr || arr.length <= 1){
            return arr;
        }

        sortDesc(arr, 0, arr.length - 1);

        return  arr;
    }

    private void sortDesc(int[] arr, int fromInc, int toInc) {
        if (fromInc >= toInc) {
            return;
        }

        int pivot = partionDesc(arr, fromInc, toInc);
        sortDesc(arr, fromInc, pivot - 1);
        sortDesc(arr, pivot + 1, toInc);
    }

    private int partionDesc(int[] arr, int fromInc, int toInc) {
        // {9, 0, 8, 10, -5, 2, 13, 7}
        // f                        b
        int lastEmptyIdx = (fromInc + toInc) / 2;
        int val = arr[lastEmptyIdx];
        int forwardIdx = fromInc, backwardIdx = toInc;

        while (forwardIdx < backwardIdx){
            while (forwardIdx < backwardIdx && arr[forwardIdx] >= val){
                forwardIdx++;
            }
            arr[lastEmptyIdx] = arr[forwardIdx];
            lastEmptyIdx = forwardIdx;

            while (forwardIdx < backwardIdx && arr[backwardIdx] <= val){
                backwardIdx--;
            }
            arr[lastEmptyIdx] = arr[backwardIdx];
            lastEmptyIdx = backwardIdx;
        }
        arr[forwardIdx] = val;

        return forwardIdx;
    }
}
