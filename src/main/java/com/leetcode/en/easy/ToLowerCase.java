package com.leetcode.en.easy;


public class ToLowerCase {
    static class Solution {
        public String toLowerCase(String str) {
            StringBuilder buffer = new StringBuilder(str.length());
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if(isLetter(chars[i]) && isUpperCase(chars[i])){
                    chars[i] = toLowerCase(chars[i]);
                }
            }

            return new String(chars);
        }

        private boolean isLetter(char ch) {
            return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
        }

        private boolean isUpperCase(char ch) {
            return (ch >= 'A' && ch <= 'Z');
        }

        private char toLowerCase(char ch) {
            return (char)(ch + 32);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toLowerCase("122C"));
        System.out.println(solution.toLowerCase("judisCsdkjjdsZA"));
        System.out.println(solution.toLowerCase("122C"));
        System.out.println((int)'A');
        System.out.println((int)'a');
        System.out.println((int)'Z');
        System.out.println((int)'z');
        System.out.println('z' - 'Z');
    }
}
