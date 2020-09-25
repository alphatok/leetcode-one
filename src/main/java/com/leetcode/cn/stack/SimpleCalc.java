package com.leetcode.cn.stack;

import org.junit.Assert;

import java.util.Stack;

public class SimpleCalc {

    public static void main(String[] args) {
        Assert.assertEquals(1, calc("2-1"));
        Assert.assertEquals(-3, calc("2-1*5"));
        Assert.assertEquals(0, calc("2-1*5+3"));
        Assert.assertEquals(3, calc("2-1*5+3*2"));
        Assert.assertEquals(0, calc("2-1*5+1*3*2-9/3"));
        Assert.assertEquals(14, calc("1*7*2"));
        Assert.assertEquals(2, calc("8/2/2"));
    }

    private static int calc(String exp) {
        Stack<String> opStack = new Stack<>();
        Stack<Character> signStack = new Stack<>();
        for (char ch : exp.toCharArray()) {
            if ( isDigital(ch) ){
                opStack.push(String.valueOf(ch));
            }

            if( isSign(ch)){
                while (!signStack.isEmpty()) {
                    Character sign = signStack.peek();
                    if ( greaterEqMe(sign, ch) ){
                        sign = signStack.pop();
                        String a = opStack.pop();
                        String b = opStack.pop();
                        String result = calc(b, a, sign);
                        opStack.push(result);
                    }else{
                        break;
                    }
                }

                signStack.push(ch);
            }
        }

        while (!signStack.isEmpty()) {
            Character sign = signStack.pop();
            String a = opStack.pop();
            String b = opStack.pop();
            String result = calc(b, a, sign);
            opStack.push(result);
        }
        return Integer.parseInt(opStack.pop());
    }

    private static String calc(String a, String b, Character sign) {
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        switch (sign) {
            case '-':
                return String.valueOf(x - y);
            case '+':
                return String.valueOf(x + y);
            case '*':
                return String.valueOf(x * y);
            case '/':
                return String.valueOf(x / y);
            default:
                throw new RuntimeException();
        }
    }

    private static boolean greaterEqMe(char sign, char ch) {
        return shadowV(sign) >= shadowV(ch);
    }

    private static int shadowV(char sign) {
        int  a;
        if ((sign == '*' || sign == '/')) {
            a = 1;
        }else{
            a = -1;
        }

        return a;
    }

    private static boolean isSign(char ch) {
        return ch == '+' ||
                ch == '-' ||
                ch == '*' ||
                ch == '/';
    }

    private static boolean isDigital(char ch) {
        return ch >='0' && ch <= '9';
    }
}
