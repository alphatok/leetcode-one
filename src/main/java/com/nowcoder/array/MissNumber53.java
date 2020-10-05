package com.nowcoder.array;

public class MissNumber53 {


    public static class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int sum = n*(n+1)/2;
            int missSum = 0;
            for (int val : nums){
                missSum += val;
            }

            return sum - missSum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
        System.out.println(new Solution().missingNumber(new int[]{0,1,3}));
    }
}
