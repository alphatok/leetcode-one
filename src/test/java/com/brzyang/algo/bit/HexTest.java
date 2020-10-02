package com.brzyang.algo.bit;

import org.junit.Test;

public class HexTest {

    @Test
    public void test(){
        System.out.println("Integer.toString(10, 16) = " + Integer.toString(10, 16));
        System.out.println("Integer.toString(11, 16) = " + Integer.toString(11, 16));
        System.out.println("Integer.toString(12, 16) = " + Integer.toString(12, 16));
        System.out.println("Integer.toString(13, 16) = " + Integer.toString(13, 16));
        System.out.println("Integer.toString(14, 16) = " + Integer.toString(14, 16));
        System.out.println("Integer.toString(15, 16) = " + Integer.toString(15, 16));
        System.out.println("Integer.toString(16, 16) = " + Integer.toString(16, 16));

        assert "a".equals(Integer.toString(10, 16));
        assert "b".equals(Integer.toString(11, 16));
        assert "c".equals(Integer.toString(12, 16));
        assert "d".equals(Integer.toString(13, 16));
        assert "e".equals(Integer.toString(14, 16));
        assert "f".equals(Integer.toString(15, 16));
        assert "10".equals(Integer.toString(16, 16));
    }

    
}
