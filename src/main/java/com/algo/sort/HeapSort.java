package com.algo.sort;


import com.algo.util.CollectionUtil;

public class HeapSort implements AscSortInterface {
    @Override
    public int[] sortAsc(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }
//        CollectionUtil.printIntArray(arr);
        buildMaxHeap(arr, arr.length);

        int len = arr.length;
        do{
//            CollectionUtil.printIntArray(arr);
            CollectionUtil.swap(arr, 0, len - 1);

            // readjust
            len--;
            for (int i = 0; i <= len/2; i++) {
                adjustHeap(arr, i, len);
            }
        }while (len > 0);

        return arr;
    }

    private void buildMaxHeap(int[] arr, int length) {
        for (int i = length / 2; i >= 0; i--) {
            adjustHeap(arr, i, length);
        }
    }

    private void adjustHeap(int[] arr, int i, int length) {
        int left = i*2 + 1;
        int right = i*2 + 2;

        int larger = i;
        if (left < length && arr[left] > arr[i]){
            larger = left;
        }

        if (right < length && arr[right] > arr[larger]){
            larger = right;
        }

        if (larger != i){
            CollectionUtil.swap(arr, larger, i);
            adjustHeap(arr, larger, length);
        }
    }

}
