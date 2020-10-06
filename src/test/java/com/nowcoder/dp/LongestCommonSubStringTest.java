package com.nowcoder.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubStringTest {

    @Test
    public void test(){
        LongestCommonSubstring.Solution solution = new LongestCommonSubstring.Solution();
        assertEquals("-1", solution.LCS("", ""));
        assertEquals("-1", solution.LCS("", "s"));
        assertEquals("-1", solution.LCS("12", ""));
        assertEquals("-1", solution.LCS(null, ""));

//        assertEquals("a", solution.LCS("a", "a"));
//        assertEquals("a", solution.LCS("aba", "aca"));
//        assertEquals("aa", solution.LCS("abaa", "acaa"));
        assertEquals("abca", solution.LCS("abca", "acaabcaa"));
        assertEquals("2345", solution.LCS("1AB2345CD","12345EF"));
    }

}