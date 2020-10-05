package com.leetcode.cn.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsValidBracketTest {

    @Test
    public void test(){
        IsValidBracket.Solution solution = new IsValidBracket.Solution();
        assertFalse(solution.isValid(""));
        assertFalse(solution.isValid("["));
        assertFalse(solution.isValid("{"));
        assertFalse(solution.isValid("("));
        assertFalse(solution.isValid("(}"));
        assertFalse(solution.isValid("(]"));
        assertFalse(solution.isValid("(("));

        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("{}"));
        assertTrue(solution.isValid("[]"));
        assertTrue(solution.isValid("[{}]"));
        assertTrue(solution.isValid("[{()}]"));
        assertTrue(solution.isValid("[{()}{}{()}]"));
        assertTrue(solution.isValid("[{()}{}{()}]()"));
    }
}