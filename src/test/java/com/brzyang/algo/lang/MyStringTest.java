package com.brzyang.algo.lang;

import com.algo.lang.MyString;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStringTest {

    @Test
    public void toCharArray() {
        char[] test = {};
        char[] strArr = new MyString(test).toCharArray();
        assertArrayEquals(test, strArr);
        assertNotEquals(test, strArr);

        char[] test1 = {'1', '3', '3'};
        char[] strArr1 = new MyString(test1).toCharArray();
        assertArrayEquals(test1, strArr1);
        assertNotEquals(test1, strArr1);
    }

    @Test
    public void trim() {
        {
            MyString string = new MyString(new char[]{' ', '1'}).trim();
            assertEquals(string, new MyString(new char[]{'1'}));
        }

        {
            MyString string = new MyString(new char[]{' ', '1', ' '}).trim();
            assertEquals(string, new MyString(new char[]{'1'}));
        }

        {
            MyString string = new MyString(new char[]{' ', '1', ' ', 'x',  ' '}).trim();
            assertEquals(string, new MyString(new char[]{'1', ' ', 'x'}));
        }

        {
            MyString string = new MyString(new char[]{'1', ' ', 'x'}).trim();
            assertEquals(string, new MyString(new char[]{'1', ' ', 'x'}));
        }

        {
            assertEquals(new MyString().trim(), new MyString());
            assertEquals(true, new MyString().trim() != new MyString());
            assertArrayEquals(new MyString().trim().toCharArray(), new MyString().toCharArray());
        }
    }
}