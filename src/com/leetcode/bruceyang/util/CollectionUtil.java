package com.leetcode.bruceyang.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionUtil {

	public static <E> void print(Collection<E> collections) {
		StringBuilder builder = new StringBuilder();
		for (Iterator<E> iterator = collections.iterator(); iterator.hasNext();) {
			E e = iterator.next();
			if (e == null) {
				builder.append(",null");
			} else {
				builder.append("," + e.toString());
			}
		}

		System.out.println(builder.substring(1, builder.length()));
	}

	public static <E> void print(E[] objs) {
		StringBuilder builder = new StringBuilder();
		for (E e : objs) {
			if (e == null) {
				builder.append(",null");
			} else {
				builder.append("," + e.toString());
			}
		}
		System.out.println(builder.substring(1, builder.length()));
	}

	public static void print(int[] objs) {
		StringBuilder builder = new StringBuilder();
		for (int e : objs) {
			builder.append(","+e);
		}
		System.out.println(builder.substring(1, builder.length()));
	}

	public static void main(String[] args) {
		print(Arrays.asList(new Integer[] { 1, 34, 4, 5, 5, 2 }));
	}
}
