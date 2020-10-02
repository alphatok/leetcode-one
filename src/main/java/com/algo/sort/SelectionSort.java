package com.algo.sort;


import com.algo.util.CollectionUtil;

public class SelectionSort implements AscSortInterface, DescSortInterface {
    public int[] sortAsc(int[] arr){
        if( null == arr || arr.length <= 1){
            return arr;
        }

        // [0, loopCount -1] [loopCount, arr.length - 1]
        // dest element to select
        for (int destIndex = 0; destIndex < arr.length; destIndex++){
            // find min [loopCount, arr.length - 1]
            int minIndex = destIndex;
            for (int i = destIndex + 1; i < arr.length; i++){
                if (arr[minIndex] > arr[i]){
                    minIndex = i;
                }
            }

            // swap minIndex
            CollectionUtil.swap(arr, minIndex, destIndex);
        }

        return arr;
    }

    public int[] sortDesc(int[] arr){
        if ( null == arr || arr.length <= 1){
            return arr;
        }

        for (int destIndex = 0; destIndex < arr.length; destIndex++){
            int maxIndex = destIndex;
            for (int i = destIndex + 1; i < arr.length; i++){
                if (arr[maxIndex] < arr[i]){
                    maxIndex = i;
                }
            }

            CollectionUtil.swap(arr, maxIndex, destIndex);
        }

        return arr;
    }
}