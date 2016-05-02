package com.leetcode.bruceyang.easy;

public class ReverseBits {

	public static class Solution {

		// you need treat n as an unsigned value
		public int reverseBits(int n) {
			char[] digits = { '0', '1' };
			char[] bits = new char[32];
			for (int i = 0; i < bits.length; i++) {
				bits[i] = '0';
			}
			int index = 32;
			do {
				bits[--index] = digits[n & 1];
				n = n >>> 1;
			} while (n != 0);

			// System.out.println(new String(bits, index, (32 - index)));
			System.out.println(new String(bits));
			int result = 0;
			for (int i = 31; i >= 0; i--) {
				result <<= 1;
				if (bits[i] == '0') {
					result |= 0;
				} else {
					result |= 1;
				}
			}
			return result;
		}
	}

	public static class Solution2 {

		// you need treat n as an unsigned value
		public int reverseBits(int n) {
			int result = 0;
			for (int i = 31; i >= 0; i--) {
				result <<= 1;
				if ((n & 1) == 1) {
					result |= 1;
				}

				n = n >>> 1;
			}
			return result;
		}
	}

	public static class Solution3 {

		// you need treat n as an unsigned value
		public int reverseBits(int v) {
			// 交换每两位
			v = ((v >> 1) & 0x55555555) | ((v & 0x55555555) << 1);
			// 交换每四位中的前两位和后两位
			v = ((v >> 2) & 0x33333333) | ((v & 0x33333333) << 2);
			// 交换每八位中的前四位和后四位
			v = ((v >> 4) & 0x0F0F0F0F) | ((v & 0x0F0F0F0F) << 4);
			// 交换相邻的两个字节
			v = ((v >> 8) & 0x00FF00FF) | ((v & 0x00FF00FF) << 8);
			// 交换前后两个双字节
			v = (v >>> 16) | (v << 16);
			return v;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverseBits(1));
		System.out.println(solution.reverseBits(2));
		System.out.println(solution.reverseBits(3));
		System.out.println(solution.reverseBits(52)); //
		System.out.println(solution.reverseBits(25)); //
		System.out.println(solution.reverseBits(43261596)); // 964176192
		System.out.println(solution.reverseBits(65536)); //        32768 
		Solution2 solution2 = new Solution2();
		System.out.println(solution2.reverseBits(1));
		System.out.println(solution2.reverseBits(2));
		System.out.println(solution2.reverseBits(3));
		System.out.println(solution2.reverseBits(52)); //
		System.out.println(solution2.reverseBits(25)); // -1744830464
		System.out.println(solution2.reverseBits(43261596)); // 964176192
		System.out.println(solution2.reverseBits(65536)); //        32768 
		System.out.println("-----------------");
		Solution3 solution3 = new Solution3();
		System.out.println(solution3.reverseBits(1));
		System.out.println(solution3.reverseBits(2));
		System.out.println(solution3.reverseBits(3));
		System.out.println(solution3.reverseBits(52)); //
		System.out.println(solution3.reverseBits(25)); // -1744830464
		System.out.println(solution3.reverseBits(43261596)); // 964176192
		System.out.println(solution3.reverseBits(65536)); //        32768 

		// http://graphics.stanford.edu/~seander/bithacks.html
		// http://blog.csdn.net/maojudong/article/details/6235274
		// http://log4think.com/reverse_byte_bit/

		long b = 0; // reverse this (8-bit) byte

		b = (b * 0x0202020202L & 0x010884422010L) % 1023;

	}
}
