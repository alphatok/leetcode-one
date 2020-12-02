package com.algo.sort;

import com.alphatok.util.CollectionUtil;

public class QuickSort2 implements AscSortInterface {
    @Override
    public int[] sortAsc(int[] arr) {
        sortAsc(arr, 0, arr.length - 1);

        return arr;
    }

    private void sortAsc(int[] arr, int l, int r) {
        if (l >= r){
            // 终止条件
            return;
        }
        // partion
        int p = partion(arr, l, r);
        // sort left
        sortAsc(arr, l, p-1);
        // sort rigth
        sortAsc(arr, p+1, r);
    }

    private int partion(int[] arr, int l, int r) {
        int pIndex = l;
        int pivot = arr[l];
        while (l != r) {
            while (arr[r] >= pivot && l < r){ //  2个while 顺序不能乱，从基数的对面开始
                r--;
            }

            while (arr[l] <= pivot && l < r){
                l++;
            }

            if (l < r){
                swap(arr, l, r);
            }
//            CollectionUtil.print(arr);
        }

        arr[pIndex] = arr[r];
        arr[r] = pivot;
//        CollectionUtil.print(arr);

        return r;
    }

    private void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
