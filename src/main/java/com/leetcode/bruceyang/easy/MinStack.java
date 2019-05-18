package com.leetcode.bruceyang.easy;

public class MinStack {
	private int size = 1;
	private int[] list = new int[size];
	private int topIndex = -1;
	private int minIndex = -1;
	
	public void push(int x) {
		// if size enough
		if (topIndex + 1 >= size){
			int[] newlist = new int[size << 1];
			for (int i = 0; i < list.length; i++) {
				newlist[i] = list[i];
			}
			list = newlist;
			size = size << 1;
		}
		list[++topIndex] = x;
		
		// ajust minIndex
		if (minIndex < 0){
			minIndex = topIndex;
		}else if (list[minIndex] > x){
			ajustMinIndex(false);
		}
	}

	public void pop() {
		if (topIndex < 0) {
			return;
		}
		
		// ajust minIndex
		if (minIndex >= topIndex - 1){
			ajustMinIndex(true);
		}
		list[topIndex--] = 0;
	}
	
	private void ajustMinIndex(boolean excludeTop){
		int min = Integer.MAX_VALUE;
		int end = topIndex - (excludeTop?1:0);
		for (int i = 0; i <= end; i++) {
			if (list[i] <= min){
				minIndex = i;
				min = list[i];
			}
		}
	}

	public int top() {
		if (topIndex < 0){
			return 0;
		}
		return list[topIndex];
	}

	public int getMin() {
		if (minIndex < 0){
			return 0;
		}else{
			return list[minIndex];
		}
	}
	
	public static void case2(){
//			Input:
//			push(-10),push(14),getMin,getMin,push(-20),getMin,getMin,top,getMin,pop,push(10),push(-7),getMin,push(-7),pop,top,getMin,pop
//			Output:
//			[-10,-10,-20,-20,-20,-20,-7,-7,-7]
//			Expected:
//			[-10,-10,-20,-20,-20,-20,-10,-7,-10]
		
		MinStack minStack = new MinStack();
		minStack.push(-10);
		minStack.push(14);
		System.out.println(minStack.getMin());
		System.out.println(minStack.getMin());
		minStack.push(-20);
		System.out.println(minStack.getMin());
		System.out.println(minStack.getMin());
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		minStack.pop();
		minStack.push(10);
		minStack.push(-7);
		System.out.println(minStack.getMin());
		minStack.push(-7);
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		minStack.pop();
	}
	
	public static void case1(){
//		Input:
//		push(2147483646),push(2147483646),push(2147483647),top,pop,getMin,pop,getMin,pop,push(2147483647),top,getMin,push(-2147483648),top,getMin,pop,getMin
//		Output:
//		[2147483647,2147483646,2147483646,2147483647,2147483647,-2147483648,-2147483648,0]
//		Expected:
//		[2147483647,2147483646,2147483646,2147483647,2147483647,-2147483648,-2147483648,2147483647]
		MinStack minStack = new MinStack();
		minStack.push(2147483646);
		minStack.push(2147483646);
		minStack.push(2147483647);
		System.out.println(minStack.top());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		minStack.push(2147483647);
		minStack.top();
		System.out.println(minStack.getMin());
		minStack.push(-2147483648);
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
//		CollectionUtil.print(minStack.list);
	}
	
	public static void main(String[] args) {
		case2();
		System.out.println();
		case1();
	}
	

}
