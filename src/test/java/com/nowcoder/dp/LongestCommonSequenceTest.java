package com.nowcoder.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSequenceTest {

    @Test
    public void test(){
        LongestCommonSequence.Solution solution = new LongestCommonSequence.Solution();
        solution.LCS("1A2C3D4B56","B1D23CA45B6A");
        solution.LCS("123456778","357486782");
        solution.LCS("BDCABA","ABCBDAB");
        solution.LCS("loop","helloworld");
        solution.LCS("ABCPDSFJGODIHJOFDIUSHGD","OSDIHGKODGHBLKSJBHKAGHI");
    }

    @Test
    public void test2(){
        LongestCommonSequence.Solution solution = new LongestCommonSequence.Solution();
//        solution.LCS2("1A2C3D4B56","B1D23CA45B6A");
//        solution.LCS2("123456778","357486782");
//        solution.LCS2("BDCABA","ABCBDAB");
//        solution.LCS2("loop","helloworld");
//        solution.LCS2("ABCPDSFJGODIHJOFDIUSHGD","OSDIHGKODGHBLKSJBHKAGHI");
    }
}