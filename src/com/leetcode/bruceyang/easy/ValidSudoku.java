package com.leetcode.bruceyang.easy;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public static class Solution {
	    public boolean isValidSudoku(char[][] board) {
	    	Set<Character> set = new HashSet<>(9);
	        for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board[i][j] != '.' && !set.add(board[i][j])){
						return false;
					}
				}
				
				set.clear();
			}
	        
	        set.clear();
	        for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board[j][i] != '.' && !set.add(board[j][i])){
						return false;
					}
				}
				
				set.clear();
			}
	        
	        set.clear();
	        for (int i = 0; i < 9; i+=3) {
				for (int j = 0; j < 9; j+=3) {
					for (int q = 0; q < 3; q++) {
						for (int k = 0; k < 3; k++) {
							if (board[i+q][j+k] != '.' && !set.add(board[i+q][j+k])){
								return false;
							}
						}
					}
					set.clear();
				}
			}
	        
	        return true;
	    }
	}
	
	public static void main(String[] args) {
	}
}
