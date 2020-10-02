package com.brzyang.algo.sort;

import com.algo.sort.AscSortInterface;
import com.algo.sort.DescSortInterface;
import com.algo.util.CollectionUtil;
import com.algo.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class SortTestUtil {
    public static class Pair implements Cloneable{
        int[] expected;
        int[] input;

        public Pair(String expected, String input) {
            if (expected != null) {
                this.expected = StringUtil.splitAsIntArray(expected);
            }
            if (input != null) {
                this.input = StringUtil.splitAsIntArray(input);
            }
        }

        public Pair(int[] expected, int[] input) {
            this.expected = expected;
            this.input = input;
        }

        public int[] getExpected() {
            return expected;
        }

        public int[] getInput() {
            return input;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            Pair pair = (Pair) super.clone();
            if (expected != null) {
                pair.expected = expected.clone();
            }
            if (input != null) {
                pair.input = input.clone();
            }
            return pair;
        }
    }

    // 32 768
    private static int RANDOM_TEST_COUNT = 1 << 10;

    private static List<Pair> ascTestCases = new ArrayList<>(RANDOM_TEST_COUNT + 10);
    private static List<Pair> descTestCases = new ArrayList<>(RANDOM_TEST_COUNT + 10);

    static{
        ascTestCases.add(new Pair(new int[]{}, new int[]{}));
        ascTestCases.add(new Pair(new int[]{1}, new int[]{1}));
        ascTestCases.add(new Pair(new int[]{1,2,3}, new int[]{1,2,3}));
        ascTestCases.add(new Pair(new int[]{1,2,3}, new int[]{2,3,1}));
        ascTestCases.add(new Pair(new int[]{1,2,3}, new int[]{3,2,1}));
        ascTestCases.add(new Pair(new int[]{0,1,2,3}, new int[]{3,2,1,0}));
        ascTestCases.add(new Pair(new int[]{1,1,1,2}, new int[]{2,1,1,1}));
        ascTestCases.add(new Pair(new int[]{0,1,2,3,4,5,6,7,8,9}, new int[]{8,9,1,7,2,3,5,4,6,0}));

        for (int i = 0; i < RANDOM_TEST_COUNT - 100; i++) {
            int arrayLen = new Random().nextInt(1000) + 10;
            int[] input = new int[arrayLen];
            for (int j = 0; j < arrayLen; j++) {
                int val = (int) (Math.random() * 100000);
                if (Math.random() > 0) {
                    val = -1 * val;
                }
                input[j] = val;
            }
            int[] output = input.clone();
            Arrays.parallelSort(output);

            Pair pair = new Pair(output, input);
            ascTestCases.add(pair);
        }
    }

    static{
        descTestCases.add(new Pair(new int[]{}, new int[]{}));
        descTestCases.add(new Pair(new int[]{1}, new int[]{1}));
        descTestCases.add(new Pair(new int[]{3,2,1}, new int[]{1,2,3}));
        descTestCases.add(new Pair(new int[]{3,2,1}, new int[]{2,3,1}));
        descTestCases.add(new Pair(new int[]{3,2,1}, new int[]{3,2,1}));
        descTestCases.add(new Pair(new int[]{3,2,1,0}, new int[]{3,2,1,0}));
        descTestCases.add(new Pair(new int[]{2,1,1,1}, new int[]{2,1,1,1}));
        descTestCases.add(new Pair(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[]{8,9,1,7,2,3,5,4,6,0}));

        for (int i = 0; i < RANDOM_TEST_COUNT - 100; i++) {
            int arrayLen = new Random().nextInt(1000) + 10;
            int[] input = new int[arrayLen];
            for (int j = 0; j < arrayLen; j++) {
                int val = (int) (Math.random() * 100000);
                if (Math.random() > 0) {
                    val = -1 * val;
                }
                input[j] = val;
            }
            int[] output = input.clone();
            Arrays.parallelSort(output);
            CollectionUtil.reverse(output);
            Pair pair = new Pair(output, input);
            descTestCases.add(pair);
        }
    }

    public void testAsc(AscSortInterface sortInterface){
        for (Pair pairOri : ascTestCases) {
            Pair pair;
            try {
                pair = (Pair)pairOri.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("", e);
            }
            String expected = CollectionUtil.join(pairOri.getExpected());
            int[] results = sortInterface.sortAsc(pair.getInput());
            String raw = CollectionUtil.join(pairOri.getInput());
            String resultStr = CollectionUtil.join(results);
            assertArrayEquals("\r\ninput: \r\n" + raw +
                            "\r\nexpected: \r\n" + expected +
                            "\r\nresults:\r\n" + resultStr,
                    pair.getExpected(), results);
        }
    }

    public void testDesc(DescSortInterface sortInterface){
        for (Pair pairOri : descTestCases) {
            Pair pair;
            try {
                pair = (Pair)pairOri.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("", e);
            }
            String expected = CollectionUtil.join(pairOri.getExpected());
            int[] results = sortInterface.sortDesc(pair.getInput());
            String raw = CollectionUtil.join(pairOri.getInput());
            String resultStr = CollectionUtil.join(results);
            assertArrayEquals("input: \r\n" + raw +
                            "\r\nexpected: \r\n" + expected +
                            "\n\nresults:\r\n" + resultStr,
                    pair.getExpected(), results);
        }
    }
}
