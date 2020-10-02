package com.algo.sort;

public class ShellSort2 implements AscSortInterface, DescSortInterface {
    @Override
    public int[] sortAsc(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }

        int gap = arr.length / 2;
        while (gap > 0){
            for (int gapIndex = 0; gapIndex < gap; gapIndex++){
                for (int piv = gapIndex + gap; piv < arr.length; piv += (gap)){
                    int pivVal = arr[piv];

                    int destIndex = piv - gap;
                    for (; destIndex >=0; destIndex -= gap){
                        if (arr[destIndex] > pivVal){
                            arr[destIndex + gap] = arr[destIndex];
                        }else{
                            break;
                        }
                    }

                    arr[destIndex + gap] = pivVal;
                }
            }

            gap /= 2;
        }

        return arr;
    }

    @Override
    public int[] sortDesc(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }

        int gap = arr.length / 2;
        while (gap > 0){
            for (int gapIndex = 0; gapIndex < gap; gapIndex++){
                for (int piv = gapIndex + gap; piv < arr.length; piv += (gap)){
                    int pivVal = arr[piv];

                    int destIndex = piv - gap;
                    for (; destIndex >=0; destIndex -= gap){
                        if (arr[destIndex] < pivVal){
                            arr[destIndex + gap] = arr[destIndex];
                        }else{
                            break;
                        }
                    }

                    arr[destIndex + gap] = pivVal;
                }
            }

            gap /= 2;
        }

        return arr;
    }
}
