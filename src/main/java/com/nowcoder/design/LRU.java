package com.nowcoder.design;

import java.util.*;

public class LRU {
    public static class Solution {
        /**
         * lru design
         *
         * @param operators int整型二维数组 the ops
         * @param k         int整型 the k
         * @return int整型一维数组
         */
        public int[] LRU(int[][] operators, int k) {
            Map<Integer, Integer> cache = new LinkedHashMap<>();
            List<Integer> result = new ArrayList<>(operators.length / 2 + 1);

            for (int[] element : operators) {
                int type = element[0];
                int key = element[1];
                switch (type) {
                    case 1:
                        int value = element[2];
                        if (cache.containsKey(key)) {
                            cache.remove(key);
                            cache.put(key, value);
                        } else {
                            if (cache.size() >= k) {
                                // remove last
                                Map.Entry<Integer, Integer>[] arr = cache.entrySet().toArray(new Map.Entry[0]);
                                Integer rkey = arr[0].getKey();
                                cache.remove(rkey);
                            }

                            cache.put(key, value);
                        }

                        break;
                    case 2:
                        Integer val = cache.get(key);
                        if (val != null) {
                            cache.remove(key);
                            cache.put(key, val);
                            result.add(val);
                        } else {
                            result.add(-1);
                        }
                        break;
                    default:
                        break;
                }

            }

            int[] ret = new int[result.size()];
            int index = 0;
            for (Integer v : result) {
                ret[index++] = v;
            }

            return ret;
        }
    }
}
