package com.nowcoder.dac;

public class FindGreatestSumOfSubArray {
    public static class Solution {
        /**
         * divide and conqure
         *
         * @param array
         * @return
         */
        public int FindGreatestSumOfSubArray(int[] array) {
            // left right 可能在left 也可能在 right，也可能 right和left中间
            if (array.length == 1){
                return array[0];
            }

            return maxSumSubArray(array, 0, array.length - 1);
        }

        private int maxSumSubArray(int[] array, int l, int r) {
            if (l == r) {
                return array[l];
            }

            // 0 1; 4,5,6; 4,5,6,7
            int m = l + (r - l) / 2; // middle
            return max(maxSumSubArray(array, l, m),
                    maxSumSubArray(array, m + 1, r),
                    maxMergeSumSubArray(array, l, m, r));
        }

        /**
         * 左数组的最大后缀和右数组的最大前缀的和
         * m-1,m, m+1, m+2 (must include m and m+1)
         */
        //
        private int maxMergeSumSubArray(int[] array, int l, int m, int r) {
            int maxLeft = Integer.MIN_VALUE;
            int newLeftSum = 0;
            for (int i = m; i >= l; i--) {
                newLeftSum += array[i];
                if (newLeftSum > maxLeft){
                     maxLeft = newLeftSum;
                }
            }

            int maxRight = Integer.MIN_VALUE;
            int newRightSum = 0;
            for (int i = m + 1; i <= r; i++) {
                newRightSum += array[i];
                if (newRightSum > maxRight) {
                    maxRight = newRightSum;
                }
            }

            return maxLeft + maxRight;
        }

        private int max(int... vals) {
            int max = vals[0];
            for (int i = 1; i < vals.length; i++) {
                if (vals[i] > max){
                    max = vals[i];
                }
            }
            return max;
        }
    }
}