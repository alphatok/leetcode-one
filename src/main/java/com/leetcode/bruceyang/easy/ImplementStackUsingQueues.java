package com.leetcode.bruceyang.easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
	
	// LILO
	public static class MyStack {
		
		Queue<Integer> data = new LinkedList<>(); // FIFO
		
	    // Push element x onto stack.
	    public void push(int x) {
	    	Queue<Integer> tmp = new LinkedList<>();
	    	tmp.add(x);
	    	tmp.addAll(data);
	    	data = tmp;
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	    	if (data.size() > 0){
	        	data.poll();
	        }else {
			}
	    }

	    // Get the top element.
	    public int top() {
	        if (data.size() > 0){
	        	return data.peek();
	        }else {
				return -1;
			}
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	    	return !(data.size() > 0);
	    }
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		System.out.println(stack.top());
		
	}
}
