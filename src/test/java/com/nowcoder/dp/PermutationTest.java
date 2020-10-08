package com.nowcoder.dp;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PermutationTest {

    @Test
    public void testSolution1(){
        Permutation.Solution solution = new Permutation.Solution();
        assertTrue(solution.Permutation("").isEmpty());
        {
            ArrayList<String> list = solution.Permutation("a");
            assertEquals(1, list.size());
        }

        {
            ArrayList<String> list = solution.Permutation("aa");
            assertEquals(1, list.size());
        }

        ArrayList<String> list = solution.Permutation("abc");
        assertEquals(6, list.size());
        assertEquals("abc", list.get(0));
        assertEquals("acb", list.get(1));
        assertEquals("bac", list.get(2));
        assertEquals("bca", list.get(3));
        assertEquals("cab", list.get(4));
        assertEquals("cba", list.get(5));
    }

}