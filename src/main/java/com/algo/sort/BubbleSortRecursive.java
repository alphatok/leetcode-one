package com.algo.sort;


import com.alphatok.util.CollectionUtil;

public class BubbleSortRecursive implements AscSortInterface {

    @Override
    public int[] sortAsc(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        sortAsc(arr, arr.length - 1);

        return arr;
    }

    private void sortAsc(int[] arr, int bubbleIndex) {
        if (bubbleIndex == 0) {
            return;
        }

        for (int i = 0; i < bubbleIndex; i++){
            if (arr[i] > arr[i+1]){
                CollectionUtil.swap(arr, i, i+1);
            }
        }

        sortAsc(arr, bubbleIndex - 1);
    }
}
