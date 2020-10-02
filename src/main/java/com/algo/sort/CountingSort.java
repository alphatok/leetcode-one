package com.algo.sort;

import java.util.Arrays;

public class CountingSort implements AscSortInterface {
    @Override
    public int[] sortAsc(int[] arr) {
        if (null == arr || arr.length <= 0) {
            return arr;
        }
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        int size = max - min + 1;
        int[] countArr = new int[size];
//        Arrays.fill(countArr, 0);
        for (int value : arr) {
            countArr[value - min]++;
        }

        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0){
                arr[index++] = min + i;
                countArr[i]--;
            }
        }

        return arr;
    }
}
