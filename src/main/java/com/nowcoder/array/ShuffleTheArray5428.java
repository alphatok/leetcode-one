package com.nowcoder.array;

public class ShuffleTheArray5428 {
    public static class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] ret = new int[2*n];
            int x = 0;
            int y = n;
            int retIndex = 0;
            while (x < n){
                ret[retIndex++] = nums[x++];
                ret[retIndex++] = nums[y++];
            }

            return ret;
        }
    }

    public static void main(String[] args) {
        int[] case1 = {1, 2};
        int[] case2 = {1, 2, 3, 4};
        int[] case3 = {1, 2, 3, 4, 5, 6};

        // y(i) = 2n/2 + i  -> y(i) = 2*i + 1
        // x(i) = i  ->   x(i) = 2i;
    }
}
