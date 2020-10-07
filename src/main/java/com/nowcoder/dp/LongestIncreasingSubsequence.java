package com.nowcoder.dp;

import jdk.nashorn.internal.ir.IfNode;

import java.lang.reflect.Array;
import java.text.BreakIterator;
import java.util.*;

/**
 * 递归公式 https://www.jianshu.com/p/b3580d3e4dab
 */
public class LongestIncreasingSubsequence {


    public static class Solution {
        /**
         * retrun the longest increasing subsequence
         * @param arr int整型一维数组 the array
         * @return int整型一维数组
         */
        public int[] LIS(int[] arr) {
            if ( arr == null || arr.length == 0){
                return new int[]{};
            }

            // i结尾的数组中
            int[] dp = new int[arr.length];
            Arrays.fill(dp, 1);
            List<Integer> preIdxes = new ArrayList<>(arr.length);
            preIdxes.add(-1);

            int globalMax = 1;
            for (int outIdx = 1; outIdx < arr.length; outIdx++){
                int cur = arr[outIdx];

                for (int inIdx = 0; inIdx < outIdx; inIdx++) {
                    if (cur > arr[inIdx]){
                        int tmp = dp[inIdx] + 1;
                        if (tmp > dp[outIdx]){
                            dp[outIdx] = tmp; // possible overwrite
                        }
                    }
                }

                int minIndex = -1;
                for (int inIdx = 0; inIdx < outIdx; inIdx++) {
                    if (dp[inIdx] + 1 == dp[outIdx]) {
                        if (minIndex < 0){
                            minIndex = inIdx;
                        }else {
                            if (arr[minIndex] > arr[inIdx]){ //choose smaller one
                                minIndex = inIdx;
                            }
                        }
                    }
                }
                preIdxes.add(minIndex);

                if (globalMax < dp[outIdx]){
                    globalMax = dp[outIdx];
                }
            }

            List<String> rs = new ArrayList<>();
            for (int i = dp.length - 1; i >= 0; i--) {
                if (dp[i] == globalMax) {
                    StringBuilder buffer = new StringBuilder();
                    buffer.append(arr[i]).append(",");
                    // pre index part
                    Integer preIndex = preIdxes.get(i);
                    while (preIndex >= 0){
                        buffer.append(arr[preIndex]).append(",");
                        preIndex = preIdxes.get(preIndex);
                    }

                    rs.add(buffer.reverse().toString());
                }
            }
            rs.sort(String::compareTo);
//            for (String r : rs) {
//                System.out.println(r);
//            }
            String smallest = rs.get(0);
            String[] split = smallest.substring(1).split(",");
            int[] ret = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                ret[i] = Integer.parseInt(split[i]);
            }

            return ret;
/*
            for (int i = 0; i < arr.length; i++) {
                System.out.print (String.format("%2s ", i));
            }
            System.out.println("");
            for (int i = 0; i < arr.length; i++) {
                System.out.print (String.format("%2s ", arr[i]));
            }
            System.out.println("");
            for (int i = 0; i < dp.length; i++) {
                System.out.print (String.format("%2s ", dp[i]));
            }
            System.out.println("");
            for (int i = 0; i < preIdxes.size(); i++) {
                System.out.print (String.format("%2s ", preIdxes.get(i)));
            }

            System.out.println(globalMax + "");
            System.out.println("");
            return new int[]{};*/
        }
    }

}
