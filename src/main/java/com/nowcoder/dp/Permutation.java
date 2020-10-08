package com.nowcoder.dp;

import java.util.*;


public class Permutation {


    /**
     * https://www.cnblogs.com/pmars/archive/2013/12/04/3458289.html 字典序法
     */
    public static class Solution3 {
        public ArrayList<String> Permutation(String str) {
            return null;
        }
    }


    /**
     * recursive
     * 每次从字符数组中选取一个元素(从第一个开始到最后一个结束)，作为结果的第一元素，剩下的元素做全排列
     */
    public static class Solution2 {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> list = new ArrayList<>();
            if (str == null || str.length() == 0) {
                return list;
            }

            Set<String> cache = new HashSet<>();
            char[] array = str.toCharArray();
            fullPermutation(array, 0, cache);

            return list;
        }

        private void fullPermutation(char[] array, int from, Set<String> cache) {
            if (from == array.length - 1) {
                String p = Arrays.toString(array);
                if (cache.contains(p)) {
                    return;
                }

                cache.add(p);
            }

            for (int i = from; i < array.length; i++) {
                // slot [i]
                swap(array, i, from);
//                fullPermutation(array, i + 1);
            }
        }

        private void swap(char[] array, int i, int j) {
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    /**
     * https://leetcode-cn.com/problems/permutations/solution/46quan-pai-lie-de-dong-tai-gui-hua-shi-xian-by-lao/
     * dp[k] = for(k * dp[k-1]中全排列集合数){
     *   insert(k,dp[k-1])
     *   }
     */
    public static class Solution {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> list = new ArrayList<>();
            if (str == null || str.length() == 0) {
                return list;
            }

            char[] array = str.toCharArray();
            List<List<Character>> preDpResult = new LinkedList<>();
            ArrayList<Character> dp0 = new ArrayList<>();
            dp0.add(array[0]);
            preDpResult.add(dp0);
            for (int i = 1; i < array.length; i++) {
                Character character = array[i];
                List<List<Character>> curDpResult = new LinkedList<>();
                for (List<Character> plist : preDpResult) {
                    for (int v = 0; v <= plist.size(); v++) {
                        List<Character> newPlist = new ArrayList<>(plist);
                        newPlist.add(v, character);
                        curDpResult.add(newPlist);
                    }
                }

                preDpResult = curDpResult;
            }

            ArrayList<String> result = new ArrayList<>(preDpResult.size());
            Set<String> cache = new HashSet<>();
            StringBuilder buffer = new StringBuilder();
            for (List<Character> characters : preDpResult) {
                buffer.delete(0, buffer.length());
                for (Character character : characters) {
                    buffer.append(character);
                }

                String rs = buffer.toString();
                if (cache.contains(rs)) {
                    continue;
                }
                cache.add(rs);
                result.add(rs);
            }
            result.sort(String::compareTo);


            return result;
        }
    }

}
