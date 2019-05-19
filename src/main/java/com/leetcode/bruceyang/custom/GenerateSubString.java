package com.leetcode.bruceyang.custom;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GenerateSubString {

    public static class SubStringGenerator{
        /**
         * for
         *
         * @param s
         * @return
         */
        List<String> generate(String s){
            List<String> res = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i+1; j <= s.length(); j++) {
                    res.add(s.substring(i, j));
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SubStringGenerator generator = new SubStringGenerator();
        System.out.println(generator.generate("bbb"));
        System.out.println(generator.generate("asd"));
        System.out.println(generator.generate("a"));
        System.out.println(generator.generate("ab"));
        System.out.println(generator.generate("avcd"));
        System.out.println(generator.generate("12338838371937699632516262388"));
    }
}
