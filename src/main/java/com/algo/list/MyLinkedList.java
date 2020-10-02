package com.algo.list;


public class MyLinkedList {
    private MyListNode first;
    private MyListNode last;

    public MyLinkedList() {
    }

    public MyListNode append(MyListNode node){
        if (node == null) {
            throw new NullPointerException("null");
        }

        if(first == null) {
            this.first = node;
        }else{
            last.setNext(node);
        }
        this.last = node;

        return last;
    }

    public MyListNode getFirst() {
        return first;
    }

    public void setFirst(MyListNode first) {
        this.first = first;
    }

    public MyListNode getLast() {
        return last;
    }

    public void setLast(MyListNode last) {
        this.last = last;
    }
}
