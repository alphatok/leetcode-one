package com.algo.util;


import com.algo.list.MyLinkedList;
import com.algo.list.MyListNode;

public class MyLinkedListUtil {

/*    public static MyLinkedList mergeAsc(MyLinkedList a, MyLinkedList b){
        while (a != null && b != null){

        }


    }*/

    /**
     *
     * @param arr non null
     * @return
     */
    public static MyLinkedList toLinkedList(int[] arr){
        MyLinkedList linkedList = new MyLinkedList();
        for (int val : arr) {
            linkedList.append(new MyListNode(val));
        }

        return linkedList;
    }

    /**
     *
     * @param list non null
     * @return
     */
    public static int[] toArray(MyLinkedList list){
        // length
        int len = 0;
        MyListNode tmp = list.getFirst();
        while(tmp != null){
            len++;
            tmp = tmp.getNext();
        }

        int[] result = new int[len];
        MyListNode node = list.getFirst();
        int index = 0;
        while (node != null){
            result[index++] = node.getData();
            node = node.getNext();
        }

        return result;
    }

    public static MyLinkedList sortLinkedListAsc(MyLinkedList list) {
        if (list.getFirst() == null) {
            return list;
        }

        MyLinkedList resultList = new MyLinkedList();
        MyListNode listNode = sortLinkedListAsc(list.getFirst());
        resultList.append(listNode);
        return resultList;
    }

    private static MyListNode sortLinkedListAsc(MyListNode head) {
        // length
        int len = 0;
        MyListNode nodeTmp = head;
        while (nodeTmp != null){
            len++;
            nodeTmp = nodeTmp.getNext();
        }

        // bubble
        for (int i = 0; i < len; i++) {
            int innnerStopCount = len - i;
            MyListNode pre = null;
            MyListNode cur = head;
            while (innnerStopCount >= 0 && cur != null){
                MyListNode next = cur.getNext();
                if (next == null){
                    break;
                }else {
                    if (next.getData() < cur.getData()){
                        if (pre == null){
                            // cur is head, switch cur and next then next as head
                            cur.setNext(next.getNext());
                            next.setNext(cur);
                            head = next;
                        }else{
                            // switch cur and next
                            pre.setNext(next);
                            cur.setNext(next.getNext());
                            next.setNext(cur);
                        }
                        pre = next;
                        // cur remains
                    }else{
                        pre = cur;
                        cur = next;
                    }

                }
            }
        }

        return head;
    }
}
