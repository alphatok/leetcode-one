package com.algo.sort;


import com.algo.list.MyLinkedList;
import com.algo.util.MyLinkedListUtil;

public class BubbleSortLinkedList implements AscSortInterface {
    @Override
    public int[] sortAsc(int[] arr) {
        if (null == arr || arr.length < 1) {
            return arr;
        }

        MyLinkedList list = MyLinkedListUtil.toLinkedList(arr);
        return MyLinkedListUtil.toArray(MyLinkedListUtil.sortLinkedListAsc(list));
    }

}
