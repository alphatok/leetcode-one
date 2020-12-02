package com.algo.sort;

public class HeapSort2 implements AscSortInterface {

    private static void buildHeap(int[] arr, int hpIndex, int length) {
        for (int i = hpIndex / 2; i >= 0; i--) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < length && arr[l] > arr[i]){
                swap(arr, i, l);
            }
            if (r < length && arr[r] > arr[i]){
                swap(arr, i, r);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Override
    public int[] sortAsc(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        // build heap (0) max
        buildHeap(arr, arr.length - 1, arr.length);

        swap(arr, 0, arr.length - 1);

        // adjust length -2 -> 0
        for (int index = arr.length - 1; index > 0; index--) {
            buildHeap(arr, index - 1, index);
            swap(arr, 0, index- 1);
        }

        return arr;
    }
}
