package com.algo.list;


public class MyListNode {

    private int data;
    public MyListNode next;

    public MyListNode(int val) {
        data = val;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public MyListNode getNext() {
        return next;
    }

    public void setNext(MyListNode next) {
        this.next = next;
    }
}
