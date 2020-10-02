
package com.algo.sort;


import static com.alphatok.util.CollectionUtil.swap;

public class BubbleSort implements AscSortInterface, DescSortInterface {

    public int[] sortAsc(final int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }

        final int maxIndex = arr.length - 1;
        for (int roundCount = 0; roundCount <= maxIndex; roundCount++) {
            for (int bubble = 0; bubble < maxIndex - roundCount; bubble++) {
                if (arr[bubble] > arr[bubble+1]) {
                    swap(arr, bubble, bubble+1);
                }
            }
        }

        return arr;
    }

    public int[] sortDesc(int[] arr){
        if (null == arr || arr.length <= 1) {
            return arr;
        }
        for (int roundCount = 0; roundCount < arr.length; roundCount++){
            for (int bubble = 0; bubble < arr.length - 1; bubble++){
                if (arr[bubble] < arr[bubble+1]){
                    swap(arr, bubble, bubble+1);
                }
            }
        }

        return arr;
    }
}