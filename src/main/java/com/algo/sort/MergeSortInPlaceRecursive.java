package com.algo.sort;

import com.alphatok.util.CollectionUtil;

/**
 * no extra large space
 */
public class MergeSortInPlaceRecursive implements AscSortInterface {
    @Override
    public int[] sortAsc(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }

        sortAsc(arr, 0, arr.length - 1);

        return arr;
    }

    private void sortAsc(int[] arr, int fromInc, int toInc) {
        if (fromInc == toInc){
            return;
        }

        int middle = (fromInc + toInc) /2;
        // sort left part
        sortAsc(arr, fromInc, middle);
        // sort right part
        sortAsc(arr, middle + 1, toInc);

        CollectionUtil.mergeAscInplaceRecursive(arr, fromInc, middle + 1, toInc);
    }

}
