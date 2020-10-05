package com.nowcoder.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValidBracket {

    public static class Solution {

        private static int LEFT = 1;
        private static int RIGHT = 2;

        /**
         *
         * @param s string字符串
         * @return bool布尔型
         */
        public boolean isValid (String s) {
            if (s == null || s.isEmpty()){
                return false;
            }

            Stack<Character> stack = new Stack<>();
            int[] blr = initBracketLR();
            Map<Character,Character> pair = initBracketPair();

            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++){
                if (blr[chs[i] - ' '] == LEFT){
                    stack.push(chs[i]);
                }else{
                    if (stack.isEmpty()){
                        return false;
                    }

                    char top = stack.pop();
                    if (pair.get(top) != chs[i]){
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }

        private int[] initBracketLR(){
            int[] brackets = new int[256];

            brackets['(' - ' '] = LEFT;
            brackets['[' - ' '] = LEFT;
            brackets['{' - ' '] = LEFT;

            brackets[')' - ' '] = RIGHT;
            brackets[']' - ' '] = RIGHT;
            brackets['}' - ' '] = RIGHT;

            return brackets;
        }

        private Map<Character,Character> initBracketPair(){
            Map<Character,Character> pair = new HashMap<>(10);
            pair.put('(', ')');
            pair.put('[', ']');
            pair.put('{', '}');

            return pair;
        }
    }
}
