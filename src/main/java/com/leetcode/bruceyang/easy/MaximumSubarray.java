package com.leetcode.bruceyang.easy;

import jdk.nashorn.internal.ir.IfNode;
import org.junit.Assert;

public class MaximumSubarray {

    /**
     * 会超时O(n^3)
     */
    static class Solution1 {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    int tmpSum = sumArray(nums, i, j);
                    if (tmpSum > max){
                        max = tmpSum;
                    }
                }
            }

            return max;
        }

        private int sumArray(int[] nums, int from, int to) {
            int sum = 0;
            for (int i = from; i <= to; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }

    /**
     *  O(n^2)
     */
    static class Solution2 {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int tmpSum = 0;
                for (int j = i; j < nums.length; j++) {
                    // sum on the fly
                    // https://www.cnblogs.com/en-heng/p/3970231.html
                    tmpSum += nums[j];
                    if (tmpSum > max){
                        max = tmpSum;
                    }
                }
            }

            return max;
        }
    }

    /**
     *  O(n^2) 斐波那契数列方式，减少计算量
     */
    static class Solution3 {
        public int maxSubArray(int[] nums) {
            int[] cumarr = new int[nums.length + 1];
            cumarr[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                cumarr[i + 1] = cumarr[i] + nums[i];
            }
            // cumarr[i] = x[0] + ... + x[i]
            // x[i..j] = cumarr[j] - cumarr[i - 1]

            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= nums.length; i++) {
                for (int j = i; j <= nums.length; j++) {
                    // sum of i..j
                    int diff = cumarr[j] - cumarr[i - 1];
                    if (diff > max) {
                        max = diff;
                    }
                }
            }

            return max;
        }
    }

    /**
     *  O(n*log(n))
     */
    static class Solution4 {
        public int maxSubArray(int[] nums) {
            return maxRecursive(nums, 0, nums.length - 1);
        }

        private int maxRecursive(int[] nums, int from, int to) {
            if (from > to) {
                return 0;
            }

            if (from == to) {
                return max(Integer.MIN_VALUE, nums[from]);
            }

            int mid = (from + to)/2;
            // 从中间元素开始往左累加的最大值 + 从中间元素开始往右累加的最大值
            int leftMax = Integer.MIN_VALUE;
            int leftSum = 0;
            for (int i = mid; i >= from; i--) {
                leftSum += nums[i];
                leftMax = max(leftSum, leftMax);
            }

            int rightSum = 0;
            int rightMax = Integer.MIN_VALUE;
            for (int i = mid + 1; i <= to; i++) {
                rightSum += nums[i];
                rightMax = max(rightSum, rightMax);
            }

            return max(rightMax + leftMax, maxRecursive(nums, from, mid), maxRecursive(nums, mid + 1, to));
        }

        private int max(int a, int b){
            return a > b ? a : b;
        }

        private int max(int a, int b, int c){
            return max(max(a, b), max(b, c));
        }
    }

    /**
     *
     */
    static class Solution5 {
        public int maxSubArray(int[] nums) {
            int[] tmp_max = new int[nums.length];
            tmp_max[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int tmp = tmp_max[i - 1] + nums[i];
                if (tmp > nums[i]) {
                    tmp_max[i] = tmp;
                }else{
                    tmp_max[i] = nums[i];
                }
            }

            int max = Integer.MIN_VALUE;
            for (int tmpMax : tmp_max) {
               if( max < tmpMax){
                   max = tmpMax;
               }
            }
            return max;
        }
    }

    /**
     * Kadane算法
     * https://www.cnblogs.com/en-heng/p/3970231.html
     *
     * 要说明Kadane算法的正确性，需要两个结论
     *
     * 首先，对于array[1...n]，如果array[i...j]就是满足和最大的子串，
     * 那么对于任何k(i<=k<=j)，我们有array[i...k]的和大于0。
     * 因为如果存在k使得array[i...k]的和小于0，那么我们就有array[k+1...j]的和大于array[i...j]，
     * 这与我们假设的array[i...j]就是array中和最大子串矛盾。
     *
     * 其次，我们可以将数组从左到右分割为若干子串，使得除了最后一个子串之外，其余子串的各元素之和小于0，
     * 且对于所有子串array[i...j]和任意k（i<=k<j），有array[i...k]的和大于0。
     */
    static class Solution6 {
        public int maxSubArray(int[] nums) {
           int max_tmp = nums[0];
           int max_global = nums[0];

            for (int i = 1; i < nums.length; i++) {
                max_tmp = max(nums[i], nums[i] + max_tmp);
                max_global = max(max_tmp, max_global);
            }
        }

        private int max(int a, int b){
            return a > b ? a : b;
        }
    }

    /**
     * 在线处理算法
     * 每输入一个数，都加进tempsum中，并与maxsum对比，如果tempsum比maxsum大，
     * 那么就更新maxsum以及对应的起始下标和终止下标。
     * 当tempsum小于零时，那么就可以放弃这一组，从下一个数重新来过了，因为此时tempsum只会拖累下一个数，使它更小（tempsum小于零）
     */
    static class Solution7 {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int tmp = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                tmp += nums[i];
                if (tmp > max) {
                    max = tmp;
                }else if (tmp < 0){
                    tmp = 0;
                }
            }

            return max;
        }
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Assert.assertEquals("", -1, solution1.maxSubArray(new int[]{-1}));
        Assert.assertEquals("", 1, solution1.maxSubArray(new int[]{1}));
        Assert.assertEquals("", 1, solution1.maxSubArray(new int[]{1, -1}));
        Assert.assertEquals("", 3, solution1.maxSubArray(new int[]{1, 2}));
        Assert.assertEquals("", 2, solution1.maxSubArray(new int[]{1, -1, 2}));
        Assert.assertEquals("", 6, solution1.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        Solution2 solution2 = new Solution2();
        Assert.assertEquals("", -1, solution2.maxSubArray(new int[]{-1}));
        Assert.assertEquals("", 1, solution2.maxSubArray(new int[]{1}));
        Assert.assertEquals("", 1, solution2.maxSubArray(new int[]{1, -1}));
        Assert.assertEquals("", 3, solution2.maxSubArray(new int[]{1, 2}));
        Assert.assertEquals("", 2, solution2.maxSubArray(new int[]{1, -1, 2}));
        Assert.assertEquals("", 6, solution2.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        Solution3 solution3 = new Solution3();
        Assert.assertEquals("", -1, solution3.maxSubArray(new int[]{-1}));
        Assert.assertEquals("", 1, solution3.maxSubArray(new int[]{1}));
        Assert.assertEquals("", 1, solution3.maxSubArray(new int[]{1, -1}));
        Assert.assertEquals("", 3, solution3.maxSubArray(new int[]{1, 2}));
        Assert.assertEquals("", 2, solution3.maxSubArray(new int[]{1, -1, 2}));
        Assert.assertEquals("", 6, solution3.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        Solution4 solution4 = new Solution4();
        Assert.assertEquals("", -1, solution4.maxSubArray(new int[]{-1}));
        Assert.assertEquals("", 1, solution4.maxSubArray(new int[]{1}));
        Assert.assertEquals("", 1, solution4.maxSubArray(new int[]{1, -1}));
        Assert.assertEquals("", 3, solution4.maxSubArray(new int[]{1, 2}));
        Assert.assertEquals("", 2, solution4.maxSubArray(new int[]{1, -1, 2}));
        Assert.assertEquals("", 6, solution4.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        Solution5 solution5 = new Solution5();
        Assert.assertEquals("", -1, solution5.maxSubArray(new int[]{-1}));
        Assert.assertEquals("", 1, solution5.maxSubArray(new int[]{1}));
        Assert.assertEquals("", 1, solution5.maxSubArray(new int[]{1, -1}));
        Assert.assertEquals("", 3, solution5.maxSubArray(new int[]{1, 2}));
        Assert.assertEquals("", 2, solution5.maxSubArray(new int[]{1, -1, 2}));
        Assert.assertEquals("", 6, solution5.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
