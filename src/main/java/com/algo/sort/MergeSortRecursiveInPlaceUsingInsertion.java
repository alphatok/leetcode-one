package com.algo.sort;

/**
 * using insertion sort
 */
public class MergeSortRecursiveInPlaceUsingInsertion implements AscSortInterface, DescSortInterface {

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
        sortAsc(arr, fromInc, middle);
        sortAsc(arr, middle + 1, toInc);
        inplaceMergeAsc(arr, fromInc, middle+1, toInc);
    }

    private void inplaceMergeAsc(int[] arr, int fromInc, int middle, int toInc) {
        int pivIndex = middle;
        for (; pivIndex <= toInc; pivIndex++ ){
            int pivVal = arr[pivIndex];

            // find index to insert
            int destIndex = pivIndex - 1;
            for (; destIndex>= fromInc; destIndex--){
                if (arr[destIndex] > pivVal){
                    arr[destIndex + 1] = arr[destIndex];
                }else{
                    break;
                }
            }

            arr[destIndex + 1] = pivVal;
        }
    }

    @Override
    public int[] sortDesc(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }

        sortDesc(arr, 0, arr.length - 1);

        return arr;
    }

    private void sortDesc(int[] arr, int fromInc, int toInc) {
        if (fromInc == toInc){
            return;
        }

        int middle = (fromInc + toInc) /2;
        sortDesc(arr, fromInc, middle);
        sortDesc(arr, middle + 1, toInc);
        inplaceMergeDesc(arr, fromInc, middle+1, toInc);

    }

    private void inplaceMergeDesc(int[] arr, int fromInc, int middle, int toInc) {
        int pivIndex = middle;
        for (; pivIndex <= toInc; pivIndex++ ){
            int pivVal = arr[pivIndex];

            // find index to insert
            int destIndex = pivIndex - 1;
            for (; destIndex>= fromInc; destIndex--){
                if (arr[destIndex] < pivVal){
                    arr[destIndex + 1] = arr[destIndex];
                }else{
                    break;
                }
            }

            arr[destIndex + 1] = pivVal;
        }

    }

}
