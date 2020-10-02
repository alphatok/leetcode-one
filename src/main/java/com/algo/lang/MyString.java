package com.algo.lang;

import java.util.Arrays;

public class MyString  {
    final char[] arr;

    public MyString(char[] arr) {
        if (arr == null) {
            throw new NullPointerException("null");
        }
        this.arr = arr;
    }

    public MyString() {
        arr = "".toCharArray();
    }

    public char[] toCharArray(){
        char[] chars = new char[arr.length];
        System.arraycopy(arr, 0, chars, 0, arr.length);
        return chars;
    }

    public MyString trim(){
        if (arr.length == 0) {
            return new MyString(arr);
        }

        char[] chars = arr;
        int fIndex = 0;
        for (; fIndex < chars.length; fIndex++) {
            if (chars[fIndex] != ' ') {
                break;
            }
        }


        int eIndex = chars.length - 1;
        for (; eIndex >= 0; eIndex--) {
            if (chars[eIndex] != ' ') {
                break;
            }
        }

        return subString(fIndex, eIndex);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myString = (MyString) o;
        return Arrays.equals(arr, myString.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }

    private MyString subString(int fromIndexInclusive, int toIndexInclusive) {
        if (arr.length - 1 < toIndexInclusive) {
            throw new RuntimeException("exceed upper bound");
        }

        if (fromIndexInclusive < 0){
            throw new RuntimeException("exceed lower bound");
        }

        if (toIndexInclusive < fromIndexInclusive){
            throw new RuntimeException("range error");
        }

        int length = toIndexInclusive - fromIndexInclusive + 1;
        char[] dest = new char[length];
        System.arraycopy(arr, fromIndexInclusive, dest, 0, length);
        return new MyString(dest);
    }
}
