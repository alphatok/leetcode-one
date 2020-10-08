package com.nowcoder.array;

public class LowerBound {

    public static class Solution {
        /**
         * 请实现有重复数字的有序数组的二分查找。
         * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
         *
         * @param n int整型 数组长度
         * @param v int整型 查找值
         * @param a int整型一维数组 有序数组
         * @return int整型
         */
        public int upper_bound_ (int n, int v, int[] a) {
            if (a == null || a.length < 1){
                return n+1;
            }

            if ( v > a[a.length - 1]){
                return n + 1;
            }else {
                int left = 0, right = n - 1;
                while (left < right){
                    int mid = (left + right) / 2;
                    if (a[mid] >= v){
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                return left;
            }
        }

        public int lower_bound_ (int v, int[] a) {
            return upper_bound_(a.length, v, a);
        }
    }

}
