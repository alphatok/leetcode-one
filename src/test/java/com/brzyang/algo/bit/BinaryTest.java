package com.brzyang.algo.bit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BinaryTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();


    @Test
    public void test(){
        int i = 8;
        int j = -8;
        System.out.println("Integer.toBinaryString(i) = " + Integer.toBinaryString(i));
        System.out.println("Integer.toBinaryString(j) = " + Integer.toBinaryString(j));

        // *2
        System.out.println("Integer.toBinaryString(i<<2) = " + Integer.toBinaryString(i << 2));
        System.out.println("Integer.toBinaryString(j<<2) = " + Integer.toBinaryString(j << 2));

        // *1/2
        System.out.println("Integer.toBinaryString(i>>2) = " + Integer.toBinaryString(i >> 2));
        System.out.println("Integer.toBinaryString(j>>2) = " + Integer.toBinaryString(j >> 2));

        System.out.println("Integer.toBinaryString(i>>>2) = " + Integer.toBinaryString(i >>> 2));
        System.out.println("Integer.toBinaryString(j>>>2) = " + Integer.toBinaryString(j >>> 2));
    }

    @Test
    public void testLogic(){
        assert (0XFF & 0X00) == 0;
        System.out.println("0X0F | 0XF0 = " + (0X0F | 0XF0));
        assert (0X0F | 0XF0) == 0XFF;
        // 0 if equals; 1 if different 半加运算（进位丢掉的加法）
        assert (0X0F ^ 0XF0) == 0XFF;
        assert (0X0F ^ 0X0F) == 0X00;
        System.out.println("~0 = " + ~0);
        System.out.println("~1 = " + ~1);
        System.out.println("~10 = " + ~10);
    }

    @Test
    public void switchVal(){
        // b^a^b=a^b^b＝a^0＝a
        int aR = 1223;
        int bR = 937;
        int a = 1223;
        int b = 937;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        assert aR == b;
        assert bR == a;
    }

//    （1） 0^0=0，0^1=1 0异或任何数＝任何数
//
//　　（2） 1^0=1，1^1=0 1异或任何数－任何数取反
//
//　　（3） 任何数异或自己＝把自己置0


    @Test
    public void flipBit(){

        int a= 0B00000001;
        System.out.println("a = " + a);
        System.out.println("a ^ 0B00000110 = " + (a ^ 0B00000110));
        assert (a ^ 0B00000110) == 7;

        // octal
        int b = 011;
        System.out.println("b = " + b);
        assert b == 9;

        // hex
        int c = 0X11;
        System.out.println("c = " + c);
        assert c == 17;
    }

    @Test
    public void resetZero(){
        int a = 0B101010010;
        a = a ^ a;
        assert a  == 0;
    }

    @Test
    public void testPowOf2ForPositive(){
        int one = 1;
        int two = 2;
        int three = 3;
        int four = 4;

        assert (one & (one - 1)) == 0;
        assert (two & (two - 1)) == 0;
        assert (three & (three - 1)) != 0;
        assert (four & (four - 1)) == 0;
    }

    @Test(expected = AssertionError.class)
    public void testPowOf2ForNegative(){
        int minusOne = -1;
        int minusTwo = -2;
        int minusThree = -3;
        // 11111111111111111111111111111111
        System.out.println("Integer.toBinaryString(minusOne) " + Integer.toBinaryString(minusOne));

        // 11111111111111111111111111111110
        System.out.println("Integer.toBinaryString(minusTwo) " + Integer.toBinaryString(minusTwo));

        // 11111111111111111111111111111101
        System.out.println("Integer.toBinaryString(minusThree) " + Integer.toBinaryString(minusThree));

        // 负数不可以
        assert (minusOne & (minusOne - 1) ) == 0;
    }
}
