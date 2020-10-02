package com.algo.sort;


import com.algo.lang.MyInteger;
import com.algo.list.MyLinkedList;
import com.algo.list.MyListNode;

import java.util.Arrays;
import java.util.OptionalInt;

public class RadixSort implements AscSortInterface {


    /**
     * -11 -12 -12827 0 12  7262  73
     *
     * [1~10 11~20]
     *  -9 ~ -0;  0 ~ 9
     * both negative and positive
     * @param arr
     * @return
     */
    @Override
    public int[] sortAsc(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }

        int maxPostiveDigitLenght = getMaxPositiveDigitLength(arr);
        int maxNegativeDigitLenght = getMaxNegativeDigitLength(arr);
        int maxDigitLen = Math.max(maxNegativeDigitLenght, maxPostiveDigitLenght);
        MyLinkedList[] list = new MyLinkedList[20];
        for (int i = 1; i <= maxDigitLen; i++) {
            for (int val : arr) {
                int len = MyInteger.stringSize(Math.abs(val));
                //
                if (i > len) {
                    if (val >= 0) {
                        appendTo(list, val, 10);
                    }else{
                        appendTo(list, val, 9);
                    }

                }else{
                    String valStr = MyInteger.toString(val, 10);
                    char ch = valStr.charAt(valStr.length() - i );
                    int dVal = ch - '0';
                    if (val >= 0) {
                        appendTo(list, val, 10 + dVal);
                    }else{
                        appendTo(list, val, 9 - dVal);
                    }
                }
            }

            // collect
            int x = 0;
            for (int i1 = 0; i1 < list.length; i1++) {
                MyLinkedList linkedList = list[i1];
                if (linkedList == null) {
                    continue;
                }

                MyListNode node = linkedList.getFirst();
                do{
                    arr[x++] = node.getData();
                    MyListNode current = node;
                    node = node.getNext();
                    // break node link
                    current.setNext(null);
                }while (node != null);

                list[i1] = null;
            }
        }

        return arr;
    }

    private void appendTo(MyLinkedList[] list, int val, int index) {
        MyLinkedList listNode = list[index];
        if (listNode == null) {
            list[index] = new MyLinkedList();
            list[index].append(new MyListNode(val));
        } else {
            listNode.append(new MyListNode(val));
        }
    }

    private int getMaxNegativeDigitLength(int[] arr) {
        OptionalInt optionalInt = Arrays.stream(arr).filter(value -> value < 0).min();
        if (optionalInt.isPresent()) {
            return MyInteger.stringSize(-optionalInt.getAsInt());
        }

        return 0;
    }

    private int getMaxPositiveDigitLength(int[] arr) {
        OptionalInt optionalInt = Arrays.stream(arr).filter(value -> value > 0).max();
        if (optionalInt.isPresent()) {
            return MyInteger.stringSize(optionalInt.getAsInt());
        }

        return 0;
    }
}
