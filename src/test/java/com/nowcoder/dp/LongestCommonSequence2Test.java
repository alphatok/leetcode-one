package com.nowcoder.dp;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LongestCommonSequence2Test {

    @Test
    public void test(){
        LongestCommonSequence2.Solution solution = new LongestCommonSequence2.Solution();
        {
            assertTrue(solution.LCSAll("1", "2").isEmpty());
        }

        {
            List<String> all = solution.LCSAll("1234", "4562");
            HashSet<String> lcsSet = new HashSet<>(all);
            assertEquals(2, lcsSet.size());
            assertTrue(lcsSet.contains("2"));
            assertTrue(lcsSet.contains("4"));
        }

        {
            List<String> all = solution.LCSAll("1A2C3D4B56","B1D23CA45B6A");
            HashSet<String> lcsSet = new HashSet<>(all);
            assertEquals(4, lcsSet.size());
            assertTrue(lcsSet.contains("1234B6"));
            assertTrue(lcsSet.contains("123456"));
            assertTrue(lcsSet.contains("12C4B6"));
            assertTrue(lcsSet.contains("12C456"));
        }

        {
            List<String> all = solution.LCSAll("123456778","357486782");
            HashSet<String> lcsSet = new HashSet<>(all);
            assertEquals(3, lcsSet.size());
            assertTrue(lcsSet.contains("35778"));
            assertTrue(lcsSet.contains("34678"));
            assertTrue(lcsSet.contains("35678"));
        }

        {
            List<String> all = solution.LCSAll("BDCABA","ABCBDAB");
            HashSet<String> lcsSet = new HashSet<>(all);
            assertEquals(3, lcsSet.size());
            assertTrue(lcsSet.contains("BDAB"));
            assertTrue(lcsSet.contains("BCAB"));
            assertTrue(lcsSet.contains("BCBA"));
        }

        {
            List<String> all = solution.LCSAll("loop","helloworld");
            HashSet<String> lcsSet = new HashSet<>(all);
            assertEquals(1, lcsSet.size());
            assertTrue(lcsSet.contains("loo"));
        }

        {
            List<String> all = solution.LCSAll("ABCPDSFJGODIHJOFDIUSHGD","OSDIHGKODGHBLKSJBHKAGHI");
            HashSet<String> lcsSet = new HashSet<>(all);
            assertEquals(2, lcsSet.size());
            assertTrue(lcsSet.contains("SDIHODSHG"));
            assertTrue(lcsSet.contains("ODIHODSHG"));
        }

    }

}