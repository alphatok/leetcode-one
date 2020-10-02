package com.algo.sort;


import com.algo.list.MyLinkedList;
import com.algo.list.MyListNode;
import com.algo.util.MyLinkedListUtil;

import java.util.Arrays;

public class BucketSort implements AscSortInterface {

    @Override
    public int[] sortAsc(int[] arr) {
        if (null == arr || arr.length <= 1){
            return arr;
        }

        // how many buckets
        int minVal = Arrays.stream(arr).min().getAsInt();
        int maxVal = Arrays.stream(arr).max().getAsInt();
        int bucketSize = 100;
        int bucketCount = (maxVal - minVal) / bucketSize + 1;
        MyLinkedList[] buckets = new MyLinkedList[bucketCount];

        // fill buckets
        for (int val : arr) {
            int bucketIndex = (val - minVal) / bucketSize;
            appendToBucket(buckets, bucketIndex, val);
        }

        // sort buckets
        for (int i = 0; i < buckets.length; i++) {
            MyLinkedList bucket = buckets[i];
            if (bucket == null) {
                continue;
            }

            buckets[i] = MyLinkedListUtil.sortLinkedListAsc(bucket);
        }

        // collect
        int index = 0;
        for (MyLinkedList bucket : buckets) {
            if (bucket == null) {
                continue;
            }

            MyListNode node = bucket.getFirst();
            do {
                arr[index++] = node.getData();
                node = node.getNext();
            }while (node != null);
        }

        return arr;
    }

    private void appendToBucket(MyLinkedList[] buckets, int bucketIndex, int val) {
        MyLinkedList bucket = buckets[bucketIndex];
        if (bucket == null) {
            buckets[bucketIndex] = new MyLinkedList();
        }

        buckets[bucketIndex].append(new MyListNode(val));
    }
}
