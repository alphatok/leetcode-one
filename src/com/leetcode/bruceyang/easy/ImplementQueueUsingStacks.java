package com.leetcode.bruceyang.easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	
	// FIFO
	public static class MyQueue {
		
		Stack<Integer> data = new Stack<>();  // LILO
 	    // Push element x to the back of queue.
	    public void push(int x) {
	    	Stack<Integer> tmp = new Stack<>();
	    	tmp.addAll(data);
	    	tmp.add(x);
	    	data = tmp;
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	    	if (data.size() > 0){
	    		data.remove(0);
	    	}
	    }

	    // Get the front element.
	    public int peek() {
	    	if (data.size() > 0){
	    		return data.get(0);
	    	}else {
				return -1;
			}
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	    	return data.size() == 0;
	    }
	}
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
//		queue.pop();
		System.out.println(queue.peek());
	}
}
