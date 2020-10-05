package com.leetcode.en.easy;

public class CompareVersionNumbers {
	public static class Solution {
		public int compareVersion(String version1, String version2) {

			String[] v1 = version1.split("\\.");
			String[] v2 = version2.split("\\.");
			int maxDot = Math.max(v1.length, v2.length);
			int[] verArr1 = new int[maxDot];
			int[] verArr2 = new int[maxDot];

			for (int i = 0; i < v1.length; i++) {
				verArr1[i] = Integer.parseInt(v1[i]);
			}

			for (int i = 0; i < v2.length; i++) {
				verArr2[i] = Integer.parseInt(v2[i]);
			}

			int sub = 0;
			for (int i = 0; i < maxDot; i++) {
				if (verArr1[i] == verArr2[i]) {
					continue;
				} else {
					sub = verArr1[i] - verArr2[i];
					break;
				}
			}

			if (sub > 0) {
				return 1;
			} else if (sub < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.compareVersion("1.1", "1.322"));
		System.out.println(solution.compareVersion("1.1", "0.2"));
		System.out.println(solution.compareVersion("1", "0.2"));
		System.out.println(solution.compareVersion("1.0", "1"));
		System.out.println(solution.compareVersion("1.0.1", "1"));
	}
}
