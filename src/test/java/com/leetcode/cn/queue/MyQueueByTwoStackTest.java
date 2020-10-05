package com.leetcode.cn.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueByTwoStackTest {


    @Test
    public void test0(){
        {
            MyQueueByTwoStack.Solution0 solution = new MyQueueByTwoStack.Solution0();
            solution.push(1);
            assertEquals(1, solution.pop());
        }

        {
            MyQueueByTwoStack.Solution0 solution = new MyQueueByTwoStack.Solution0();
            solution.push(1);
            solution.push(2);
            assertEquals(1, solution.pop());
            assertEquals(2, solution.pop());
        }

        {
            MyQueueByTwoStack.Solution0 solution = new MyQueueByTwoStack.Solution0();
            solution.push(1);
            solution.push(2);
            assertEquals(1, solution.pop());
            solution.push(3);
            assertEquals(2, solution.pop());
            assertEquals(3, solution.pop());
        }
    }


    @Test
    public void test1(){
        {
            MyQueueByTwoStack.Solution solution = new MyQueueByTwoStack.Solution();
            solution.push(1);
            assertEquals(1, solution.pop());
        }

        {
            MyQueueByTwoStack.Solution solution = new MyQueueByTwoStack.Solution();
            solution.push(1);
            solution.push(2);
            assertEquals(1, solution.pop());
            assertEquals(2, solution.pop());
        }

        {
            MyQueueByTwoStack.Solution solution = new MyQueueByTwoStack.Solution();
            solution.push(1);
            solution.push(2);
            assertEquals(1, solution.pop());
            solution.push(3);
            assertEquals(2, solution.pop());
            assertEquals(3, solution.pop());
        }
    }

    @Test
    public void test2(){
        {
            MyQueueByTwoStack.Solution2 solution = new MyQueueByTwoStack.Solution2();
            solution.push(1);
            assertEquals(1, solution.pop());
        }

        {
            MyQueueByTwoStack.Solution2 solution = new MyQueueByTwoStack.Solution2();
            solution.push(1);
            solution.push(2);
            assertEquals(1, solution.pop());
            assertEquals(2, solution.pop());
        }

        {
            MyQueueByTwoStack.Solution2 solution = new MyQueueByTwoStack.Solution2();
            solution.push(1);
            solution.push(2);
            assertEquals(1, solution.pop());
            solution.push(3);
            assertEquals(2, solution.pop());
            assertEquals(3, solution.pop());
        }
    }
}