package com.nowcoder.dp;

public class FindGreatestSumOfSubArray {
    public static class Solution {
        /**
         * recursive
         * NC67 NC19
         * @param array
         * @return
         */
        public int FindGreatestSumOfSubArray(int[] array) {
            // 状态转移方程 f(i) = max(f(i - 1) + arr[i], arr[i])
            // f(i): 第I个数结尾的 连续数字之和
            // 伴随数组，记忆
            //  1.这个最大和的连续序列只有一个元素，以arr[i]开始，arr[i]结尾
            //  2.这个最大和的连续序列多个元素，从前面arr[p]开始（p<i),一直到arr[i]结束
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


        /**
         * loop form
         * @param array
         * @return
         */
        public int FindGreatestSumOfSubArray2(int[] array) {
            // f(i) = max(f(i - 1) + arr[i], arr[i]) 第I个数结尾的 连续数字之和
            // 伴随数组，记忆
            int[] res = new int[array.length];
            // init as smallest
            for (int i = 0; i < array.length; i++){
                res[i] = Integer.MIN_VALUE;
            }

            res[0] = array[0];
            int max = res[0];
            for (int i = 1; i < array.length; i++) {
                int possibleCur = res[i - 1] + array[i]; // [...] + i
                if (possibleCur > array[i]){
                    res[i] = possibleCur;
                }else{
                    res[i] = array[i];
                }

                if (res[i] > max) {
                    max = res[i];
                }
            }

            return max;
        }
    }
}
