package com.brzyang.algo.bit;

import org.junit.Test;

public class OctalTest {
    
    @Test
    public void test(){
        System.out.println("Integer.toString(8, 8) = " + Integer.toString(8, 8));
        System.out.println("Integer.toString(9, 8) = " + Integer.toString(9, 8));
        System.out.println("Integer.toString(10, 8) = " + Integer.toString(10, 8));

        assert "10".equals(Integer.toString(8, 8));
        assert "11".equals(Integer.toString(9, 8));
        assert "12".equals(Integer.toString(10, 8));
    }
}
