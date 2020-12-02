package com.nowcoder.design;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LRUCustom {

    public static class LRUCache{
        private int maxSize;
        private Node[] hashTbl;
        private Node head;
        private Node tail;

        public LRUCache(int k) {
            maxSize = k;
            hashTbl = new Node[k];
        }

        public int set(int key, int val){
            Node node = findNode(key);
            if (node != null) {
                // if exist
                // remove from lru link
                // remove from hashTable
            }else{
                // if gt maxsize
                // remove from head
                // remove from hashTable
            }

            // add to tail
            // add to hashTable
            return 0;
        }

        private Node findNode(int key) {
            int hash = key % hashTbl.length;
            int slot = (key < 0 ? -hash : hash);
            Node slotNode = hashTbl[slot];
            if (slotNode == null){
                return null;
            }

            Node node = slotNode;
            while (node != null && node.key != key) {
                node = node.hashLink;
            }

            return node;
        }

        public Integer get(int key){
            Node node = findNode(key);
            if (node == null) {
                return null;
            }

            if (node == tail){
                return node.val;
            }else if (node == head){
                // at least two
                Node newHead = head.next;
                newHead.pre = null;
                head.next = null;
                tail.next = head;
                head.pre = tail;

                head = newHead;
                tail = head;
            }else if (node != tail){
                // at least three
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.next = null;
                node.pre = tail;
                tail.next = node;
                tail = node;
            }

            return node.val;
        }

        public static class Node{
            int val;
            int key;
            Node pre;
            Node next;
            Node hashLink;
        }
    }

    public static class Solution {
        /**
         * lru design
         *
         * @param operators int整型二维数组 the ops
         * @param k         int整型 the k
         * @return int整型一维数组
         */
        public int[] LRU(int[][] operators, int k) {

            int resultSize = 0;
            for (int[] operator : operators) {
                if (operator[0] == 2) {
                    resultSize++;
                }
            }
            int[] result = new int[resultSize];
            int resultIndex = 0;
            LRUCache lruCache = new LRUCache(k);
            for (int[] operator : operators) {
                if (operator[0] == 1){
                    lruCache.set(operator[1], operator[2]);
                }else if (operator[0] == 2){
                    Integer val = lruCache.get(operator[0]);
                    if (val == null) {
                        result[resultIndex++] = -1;
                    }else {
                        result[resultIndex++] = val;
                    }
                }
            }

            return result;
        }
    }
}
