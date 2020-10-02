package com.basic.hash;

import org.junit.Assert;

public class SimpleHashMap {
    private final int INIT_SIZE = 16;
    private NodeEntry[] array = new NodeEntry[INIT_SIZE];

    public int get(int key){
        return -1;
    }

    public void put(int key, int value){
        // size judgement
        // enlarge & rehash
        // put
    }

    public static class NodeEntry{
        private int value;
        private int key;
        private NodeEntry next;
        private NodeEntry pre;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public NodeEntry getNext() {
            return next;
        }

        public void setNext(NodeEntry next) {
            this.next = next;
        }

        public NodeEntry getPre() {
            return pre;
        }

        public void setPre(NodeEntry pre) {
            this.pre = pre;
        }
    }
    public static void main(String[] args) {

        SimpleHashMap map = new SimpleHashMap();
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);
        map.put(6,8);
        map.put(12,4);
        Assert.assertEquals(map.get(3), 4);
    }
}
