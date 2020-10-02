package com.brzyang.algo.util;

import com.algo.list.MyLinkedList;
import com.algo.list.MyListNode;
import com.algo.util.MyLinkedListUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListUtilTest {

    @Test
    public void toLinkedList() {
        int[] array = {1, 2, 3, 4};
        MyLinkedList list = MyLinkedListUtil.toLinkedList(array);
        MyListNode first = list.getFirst();
        assertEquals(1, first.getData());
        assertEquals(2, first.getNext().getData());
        assertEquals(3, first.getNext().getNext().getData());
        assertEquals(4, first.getNext().getNext().getNext().getData());
        assertNull("null", first.getNext().getNext().getNext().getNext());
    }

    @Test
    public void testToArray() {
        MyLinkedList list = new MyLinkedList();
        list.append(new MyListNode(1));
        list.append(new MyListNode(2));
        list.append(new MyListNode(3));
        list.append(new MyListNode(4));

        assertArrayEquals(new int[]{1,2,3,4}, MyLinkedListUtil.toArray(list));
        assertArrayEquals(new int[]{}, MyLinkedListUtil.toArray(new MyLinkedList()));
    }

    @Test
    public void sortLinkedListAsc() {
        {
            MyLinkedList myLinkedList = new MyLinkedList();
            assertArrayEquals(new int[]{}, MyLinkedListUtil.toArray(MyLinkedListUtil.sortLinkedListAsc(myLinkedList)));
        }

        {
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.append(new MyListNode(1));
            assertArrayEquals(new int[]{1}, MyLinkedListUtil.toArray(MyLinkedListUtil.sortLinkedListAsc(myLinkedList)));
        }

        {
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.append(new MyListNode(1));
            myLinkedList.append(new MyListNode(-10));
            myLinkedList.append(new MyListNode(10));
            myLinkedList.append(new MyListNode(9));
            myLinkedList.append(new MyListNode(4));
            assertArrayEquals(new int[]{-10, 1, 4, 9, 10}, MyLinkedListUtil.toArray(MyLinkedListUtil.sortLinkedListAsc(myLinkedList)));
        }

        {
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.append(new MyListNode(1));
            myLinkedList.append(new MyListNode(2));
            assertArrayEquals(new int[]{1,2}, MyLinkedListUtil.toArray(MyLinkedListUtil.sortLinkedListAsc(myLinkedList)));
        }

        {
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.append(new MyListNode(1));
            myLinkedList.append(new MyListNode(-10));
            myLinkedList.append(new MyListNode(10));
            myLinkedList.append(new MyListNode(9));
            myLinkedList.append(new MyListNode(1));
            myLinkedList.append(new MyListNode(100));
            myLinkedList.append(new MyListNode(-10000));
            assertArrayEquals(new int[]{-10000, -10, 1,1,9,10,100}, MyLinkedListUtil.toArray(MyLinkedListUtil.sortLinkedListAsc(myLinkedList)));
        }
    }
}