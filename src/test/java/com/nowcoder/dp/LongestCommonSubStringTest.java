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

        assertEquals("a", solution.LCS("a", "a"));
        assertEquals("a", solution.LCS("aba", "aca"));
        assertEquals("aa", solution.LCS("abaa", "acaa"));
        assertEquals("abca", solution.LCS("abca", "acaabcaa"));
        assertEquals("2345", solution.LCS("1AB2345CD","12345EF"));
    }

    @Test
    public void test2(){
        LongestCommonSubstring.Solution solution = new LongestCommonSubstring.Solution();
        assertEquals("-1", solution.LCS2("", ""));
        assertEquals("-1", solution.LCS2("", "s"));
        assertEquals("-1", solution.LCS2("12", ""));
        assertEquals("-1", solution.LCS2(null, ""));

        assertEquals("a", solution.LCS2("a", "a"));
        assertEquals("a", solution.LCS2("aba", "aca"));
        assertEquals("aa", solution.LCS2("abaa", "acaa"));
        assertEquals("abca", solution.LCS2("abca", "acaabcaa"));
        assertEquals("2345", solution.LCS2("1AB2345CD","12345EF"));
    }
}