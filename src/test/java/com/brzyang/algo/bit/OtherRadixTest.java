package com.brzyang.algo.bit;

import org.junit.Test;

public class OtherRadixTest {
    @Test
    public void test12(){
        System.out.println("Integer.toString(10, 12) = " + Integer.toString(10, 12));
        System.out.println("Integer.toString(11, 12) = " + Integer.toString(11, 12));
        System.out.println("Integer.toString(12, 12) = " + Integer.toString(12, 12));
        System.out.println("Integer.toString(13, 12) = " + Integer.toString(13, 12));

        assert "a".equals(Integer.toString(10, 12));
    }

    @Test
    public void test36(){
        System.out.println("Integer.toString(10, 36) = " + Integer.toString(10, 36));
        System.out.println("Integer.toString(11, 36) = " + Integer.toString(11, 36));
        System.out.println("Integer.toString(12, 36) = " + Integer.toString(12, 36));
        System.out.println("Integer.toString(13, 36) = " + Integer.toString(13, 36));

        System.out.println("Integer.toString(33, 36) = " + Integer.toString(33, 36));
        System.out.println("Integer.toString(34, 36) = " + Integer.toString(34, 36));
        System.out.println("Integer.toString(35, 36) = " + Integer.toString(35, 36));
        System.out.println("Integer.toString(36, 36) = " + Integer.toString(36, 36));
        System.out.println("Integer.toString(37, 36) = " + Integer.toString(37, 36));

        assert "z".equals(Integer.toString(35, 36));
        assert "10".equals(Integer.toString(36, 36));
    }
}
