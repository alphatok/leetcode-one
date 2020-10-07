package com.nowcoder.dp;

/**
 */
public class BestTimeBuySellStock {


    public static class Solution {
        /**
         * 转为 连续子数组的最大和问题
         * https://blog.csdn.net/lw_power/article/details/80892362
         *
         * @param prices int整型一维数组
         * @return int整型
         */
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) {
                return 0;
            }

            int[] priceDiff = new int[prices.length];
            for (int i = 1; i < prices.length; i++) {
                priceDiff[i] = prices[i] - prices[i - 1];
            }

            int len = priceDiff.length;
            int segmentSum = priceDiff[1];
            int res = priceDiff[1];
            for (int i = 2; i < len; i++) {
                segmentSum = Math.max(priceDiff[i], segmentSum + priceDiff[i]);
                res = Math.max(res, segmentSum);
            }

            return Math.max(res, 0);
        }

        /**
         * 动态规划
         * 记录当前位置前面所有元素的最小值即可
         *
         * @param prices
         * @return
         */
        public int maxProfit2(int[] prices) {
            if (prices == null || prices.length < 2) {
                return 0;
            }

            int maxProfit = 0;
            int minPrice = prices[0];
            for (int i = 1; i < prices.length; i++) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
                minPrice = Math.min(minPrice, prices[i]);
            }

            return maxProfit;
        }

        /**
         * 未省略dp数组 https://blog.csdn.net/andyL_05/article/details/107748816 非常清晰，用2个变量省略
         * dp[i][0]=min(dp[i−1][0],prices[i])
         * dp[i][1]=max(dp[i−1][1],prices[i]−dp[i−1][0])
         *
         * 省略了dp数组 后
         * https://blog.csdn.net/linhuanmars/article/details/23162793
         * diff = max(0, prices[i+1]-price[i])
         * local[i+1]=max(local[i] + diff, 0)  //最后一天交易
         * global[i+1]=max(local[i+1], global[i])  // 可能是最后1天交易最好，但也可能是  更早
         *
         * 变种3： https://blog.csdn.net/linhuanmars/article/details/23236995
         * @param prices
         * @return
         */
        // TODO

    }
}
