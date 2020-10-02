package com.algo.sort;

import com.alphatok.util.CollectionUtil;

public class QuickSortRandom implements AscSortInterface  {
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
        if (pivot >=1) {
            sortAsc(arr, fromInc, pivot -1);
        }
        sortAsc(arr, pivot + 1, toInc);
    }

    private int partionAsc(int[] arr, int fromInc, int toInc) {
        // 1,3,1,1,2
        //
        int valIndex =  (int) (fromInc + Math.random() * (toInc - fromInc + 1));
        int val = arr[valIndex];
        // SWAP DEST PALCE
        int lessThanValIdx = fromInc - 1;
        CollectionUtil.swap(arr, valIndex, toInc);
        for (int i = fromInc; i <= toInc; i++) {
            if (arr[i] <= val) {
                lessThanValIdx++;
                if (i > lessThanValIdx){
                    CollectionUtil.swap(arr, i, lessThanValIdx);
                }
            }
        }

        return lessThanValIdx;
    }
}
