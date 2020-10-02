package com.brzyang.algo.lang;

import com.algo.lang.MyInteger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class MyIntegerTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void stringSize() {
        assert MyInteger.stringSize(11) == 2;
        assert MyInteger.stringSize(999) == 3;
        assert MyInteger.stringSize(0) == 1;
        assert MyInteger.stringSize(-0) == 1;
        assert MyInteger.stringSize(0) == 1;
        assert MyInteger.stringSize(1) == 1;
        assert MyInteger.stringSize(9) == 1;
        assert MyInteger.stringSize(10) == 2;
        assert MyInteger.stringSize(-10) == 3;
        assert MyInteger.stringSize(Integer.MAX_VALUE) == 10;
    }

    @Test
    public void testToString() {
        assert new MyInteger(0).toString().equals("0");
        assert new MyInteger(1).toString().equals("1");
        assert new MyInteger(11).toString().equals("11");
        assert new MyInteger(-11).toString().equals("-11");
        assert new MyInteger(-919199191).toString().equals("-919199191");
        assert new MyInteger(919199191).toString().equals("919199191");
        assert new MyInteger(Integer.MAX_VALUE).toString().equals("2147483647");
        assert new MyInteger(Integer.MIN_VALUE).toString().equals("-2147483648");
    }

    @Test
    public void testToStringRadix10() {
        assert MyInteger.toString(0, 10).equals("0");
        assert MyInteger.toString(1, 10).equals("1");
        assert MyInteger.toString(11, 10).equals("11");
        assert MyInteger.toString(-11, 10).equals("-11");
        assert MyInteger.toString(-919199191, 10).equals("-919199191");
        assert MyInteger.toString(919199191, 10).equals("919199191");
        assert MyInteger.toString(Integer.MAX_VALUE, 10).equals("2147483647");
        assert MyInteger.toString(Integer.MIN_VALUE, 10).equals("-2147483648");
    }

    @Test
    public void testToStringRadix8() {
        assert MyInteger.toString(0, 8).equals("0");
        assert MyInteger.toString(7, 8).equals("7");
        assert MyInteger.toString(-7, 8).equals("-7");
        assert MyInteger.toString(8, 8).equals("10");
        assert MyInteger.toString(-8, 8).equals("-10");
        assert MyInteger.toString(9, 8).equals("11");
        assert MyInteger.toString(-9, 8).equals("-11");
    }

    @Test
    public void testToStringRadix2() {
        assert MyInteger.toString(0, 2).equals("0");
        assert MyInteger.toString(1, 2).equals("1");
        assert MyInteger.toString(10, 2).equals("1010");
        assert MyInteger.toString(-10, 2).equals("-1010");
        System.out.println("Integer.toString(-10, 2) = " + Integer.toString(-10, 2));
        System.out.println("Integer.toString(10, 2) = " + Integer.toString(10, 2));
    }

    @Test
    public void testToStringRadix16() {
        assert MyInteger.toString(0, 16).equals("0");
        assert MyInteger.toString(7, 16).equals("7");
        assert MyInteger.toString(-7, 16).equals("-7");
        assert MyInteger.toString(15, 16).equals("f");
        assert MyInteger.toString(-15, 16).equals("-f");
        assert MyInteger.toString(16, 16).equals("10");
        assert MyInteger.toString(-16, 16).equals("-10");
        assert MyInteger.toString(17, 16).equals("11");
        assert MyInteger.toString(-17, 16).equals("-11");
    }

    @Test
    public void testToStringRadix62() {
        assert MyInteger.toString(0, 62).equals("0");
        assert MyInteger.toString(7, 62).equals("7");
        assert MyInteger.toString(-7, 62).equals("-7");
        assert MyInteger.toString(15, 62).equals("f");
        assert MyInteger.toString(-15, 62).equals("-f");
        assert MyInteger.toString(61, 62).equals("Z");
        assert MyInteger.toString(-61, 62).equals("-Z");
        assert MyInteger.toString(62, 62).equals("10");
        assert MyInteger.toString(-62, 62).equals("-10");
        assert MyInteger.toString(17, 62).equals("h");
        assert MyInteger.toString(-17, 62).equals("-h");
    }

    @Test(expected = RuntimeException.class)
    public void testToStringRadix63() {
        assert MyInteger.toString(-17, 63).equals("-h");
    }


    @Test(expected = RuntimeException.class)
    public void testToStringRadix1() {
        assert MyInteger.toString(-17, 1).equals("-h");
    }

    @Test(expected = NumberFormatException.class)
    public void fromValueIllegal1() {
        MyInteger.fromValue("20292a", 10);
    }

    @Test(expected = NumberFormatException.class)
    public void fromValueIllegal2() {
        MyInteger.fromValue(" 20292", 10);
    }

    @Test(expected = NumberFormatException.class)
    public void fromValueIllegal3() {
        MyInteger.fromValue("~", 10);
    }

    @Test(expected = RuntimeException.class)
    public void fromValueTooLarge() {
        MyInteger.fromValue("21474836478", 10);
    }


    @Test(expected = RuntimeException.class)
    public void fromValueTooSmall() {
        MyInteger.fromValue("-2147483649", 10);
    }

    @Test
    public void fromValueRadix2() {
        assertEquals(new Integer(0), MyInteger.fromValue("0", 2));
        assertEquals(new Integer(1), MyInteger.fromValue("1", 2));
        assertEquals(new Integer(10), MyInteger.fromValue("1010", 2));
        assertEquals(new Integer(-10), MyInteger.fromValue("-1010", 2));
        System.out.println("Integer.valueOf(\"1010\", 2) = " + Integer.valueOf("1010", 2));
        System.out.println("Integer.valueOf(\"-1010\", 2) = " + Integer.valueOf("-1010", 2));
    }

    @Test
    public void fromValueRadix10() {
        assertEquals(new Integer(0), MyInteger.fromValue("0", 10));
        assertEquals(new Integer(0), MyInteger.fromValue("+0", 10));
        assertEquals(new Integer(0), MyInteger.fromValue("-0", 10));
        assertEquals(new Integer(-1), MyInteger.fromValue("-1", 10));
        assertEquals(new Integer(-111), MyInteger.fromValue("-111", 10));
        assertEquals(new Integer(111), MyInteger.fromValue("111", 10));
        assertEquals(new Integer(111), MyInteger.fromValue("+111", 10));
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), MyInteger.fromValue("2147483647", 10));
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), MyInteger.fromValue("+2147483647", 10));
        assertEquals(Integer.valueOf(Integer.MIN_VALUE), MyInteger.fromValue("-2147483648", 10));
    }
}