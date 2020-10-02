package com.algo.sort;

public class ShellSort implements AscSortInterface, DescSortInterface {
    @Override
    public int[] sortAsc(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }

        int gap =1;
        int step = arr.length;
        while ( gap < step/3){
            gap = 3*gap + 1;
        }

//        int gap = arr.length / 2;
//        int count = 0;
        while (gap > 0){
            // +1 ?
            // +gap
            for (int j = gap; j < arr.length; j += (1)){
                int pivVal = arr[j];

                // find the index to insert
                int destIndex = j - gap;
                for (; destIndex >= 0; destIndex -= (gap)){
                    if(arr[destIndex] > pivVal){
//                        count++;
                        arr[destIndex + gap] = arr[destIndex];
                    }else{
                        break;
                    }
                }

                //
                arr[destIndex + gap] = pivVal;
            }

            gap /= 3;
        }

//        System.out.println(count);
        return arr;
    }

    @Override
    public int[] sortDesc(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }

        int gap = arr.length / 2;
        while (gap >= 1){
            for (int gapIndex = gap; gapIndex < arr.length; gapIndex++){
                int currentVal = arr[gapIndex];

                int destIndex = gapIndex - gap;
                for (; destIndex >=0; destIndex -= gap){
                    if (arr[destIndex] < currentVal){
                        arr[destIndex + gap] = arr[destIndex];
                    }else{
                        break;
                    }
                }

                arr[destIndex + gap] = currentVal;
            }
            gap /= 2;
        }

        return arr;
    }
}
