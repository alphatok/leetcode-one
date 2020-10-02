package com.algo.sort;

public class InsertionSort implements AscSortInterface, DescSortInterface {
    @Override
    public int[] sortAsc(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        // sorted range[0, piv - 1] + unsorted range[piv, length - 1]
        for ( int piv = 1; piv <= arr.length - 1; piv++){
            int pivVal = arr[piv];

            // find the index to insert
            int destIndex;
            for (destIndex = piv - 1; destIndex >= 0; destIndex--){
                if (arr[destIndex] > pivVal) {
                    arr[destIndex + 1] = arr[destIndex];
                }else{
                    break;
                }
            }

            arr[destIndex + 1] = pivVal;
        }

        return arr;
    }

    @Override
    public int[] sortDesc(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

//        4,3,4,5
        for (int p = 1; p < arr.length; p++){
            int pVal = arr[p];

            // find the index to insert
            // start from the front element
            int destIndex = p - 1;
            for (;destIndex >=0; destIndex--){
                if (arr[destIndex] < pVal){
                    arr[destIndex + 1] = arr[destIndex];
                }else{
                    break;
                }
            }

            arr[destIndex + 1] = pVal;
        }

        return arr;
    }
}
