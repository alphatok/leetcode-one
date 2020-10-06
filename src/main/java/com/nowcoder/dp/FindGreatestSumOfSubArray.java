package com.nowcoder.dp;

public class FindGreatestSumOfSubArray {
    public static class Solution {
        public int FindGreatestSumOfSubArray(int[] array) {
            // f(i) = max(f(i - 1) + arr[i], f(i-1))
            int[] res = new int[array.length];
            // init as smallest
            for (int i = 0; i < array.length; i++){
                res[i] = Integer.MIN_VALUE;
            }

            deepSearch(array, res, array.length - 1);

            int max = Integer.MIN_VALUE;
            for (int re : res) {
                if (re > max){
                    max = re;
                }
            }

            return max;
        }

        public int deepSearch(int[] array, int[] res, int curIndex){
            if (curIndex == 0){
                res[curIndex] = array[0];
                return array[0];
            }else{
                int a = array[curIndex];
                int b = deepSearch(array, res, curIndex - 1) + array[curIndex];
                if (a > b){
                    res[curIndex] = array[curIndex];
                    return res[curIndex];
                }else{
                    res[curIndex] = b;
                    return res[curIndex];
                }
            }
        }
    }
}
