package com.nowcoder.dp;

import java.util.*;

public class LongestCommonSequence {

    public static class Solution {

        public static class Node{
            public Integer x;
            public Integer y;

            public Node(Integer x, Integer y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return Objects.equals(x, node.x) &&
                        Objects.equals(y, node.y);
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

        public static char UP = '↑';
        public static char LEFT = '←';
        public static char UP_OR_LEFT = '↖';
        public static char UP_AND_LEFT = '+';


        /**
         * longest common subsequence
         * rs[i][j] s1(0->i) 和 s2(0->j) 最长公共子串
         *
         *
         * @param s1 string字符串 the string
         * @param s2 string字符串 the string
         * @return string字符串
         */
        public String LCS(String s1, String s2) {
            if (null == s1 || null == s2){
                return "-1";
            }

            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();
            int[][] dpRS = new int[ch1.length + 1][ch2.length + 1];
            char[][] backRoute = new char[ch1.length + 1][ch2.length + 1];

            int lcs = 0;
            for (int idx1 = 0; idx1 < ch1.length; idx1++){ // row
                for (int idx2 = 0; idx2 < ch2.length; idx2++){  // column
                    int p1 = idx1 + 1;
                    int p2 = idx2 + 1;
                    if (ch1[idx1] == ch2[idx2]){
                        dpRS[p1][p2] = dpRS[idx1][idx2] + 1;
                        backRoute[p1][p2] = UP_OR_LEFT;
                    }else{
                        if (dpRS[idx1][p2] == dpRS[p1][idx2]){
                            dpRS[p1][p2] = dpRS[idx1][p2];
                            backRoute[p1][p2] = UP_AND_LEFT;
                        }else if (dpRS[idx1][p2] > dpRS[p1][idx2]) {
                            dpRS[p1][p2] = dpRS[idx1][p2];
                            backRoute[p1][p2] = UP;
                        }else{
                            dpRS[p1][p2] = dpRS[p1][idx2];
                            backRoute[p1][p2] = LEFT;
                        }
                    }

                    int tmp = dpRS[p1][p2];
                    if (tmp >= lcs){
                        lcs = tmp;
                    }
                }
            }

            System.out.println("\"\" = " + "str1:" + s1 + " s2:" + s2);
            // RETRIEVE
//            printDpRs(s1, s2, dpRS, backRoute);
            List<String> lcses = getLCS(ch1, ch2, dpRS, backRoute, lcs);
            for (int i = 0; i < lcses.size(); i++) {
                System.out.println(lcses.get(i));
            }
            System.out.println("");
            if (lcses.isEmpty()) {
                return "-1";
            }else{
                return lcses.get(0); // choose any one
            }
        }

        private List<String> getLCS(char[] ch1, char[] ch2, int[][] dpRS, char[][] backRoute, int maxLen) {
            if (maxLen <= 0) {
                return Collections.emptyList();
            }

            Set<String> lcses = new HashSet<>();
            Stack<Character> pathStack = new Stack<>();
            Stack<Stack<Character>> prePathStack = new Stack<>();

            Stack<Node> visitStack = new Stack<>(); // i-j

            visitStack.push(new Node(ch1.length, ch2.length));
            while (!visitStack.isEmpty()) {
                Node cur = visitStack.pop();
                if (cur.x == 0 || cur.y == 0){
                    lcses.add(toList(pathStack));
                    pathStack.clear();
                    if (prePathStack.isEmpty()) {
                        break;
                    }else{
                        pathStack = prePathStack.pop();
                        continue;
                    }
                }
                // if ch equals, push path; else move to prev
                if (ch1[cur.x - 1] == ch2[cur.y - 1]){
                    pathStack.push(ch1[cur.x - 1]);
                }

                // push prev (according to backRoute)
                // if backRoute '+' and not twice push cur again
                if (backRoute[cur.x][cur.y] == UP_AND_LEFT ){
                    visitStack.push(new Node(cur.x - 1, cur.y));
                    visitStack.push(new Node(cur.x, cur.y - 1));
                    prePathStack.push(pathStack);
                    Stack<Character> newPathStack = new Stack<>();
                    newPathStack.addAll(pathStack); // TODO !!NOT STACK WAY
                    pathStack = newPathStack;
                }else if (backRoute[cur.x][cur.y] == UP_OR_LEFT){
                    visitStack.push(new Node(cur.x - 1, cur.y - 1));
                } else if (backRoute[cur.x][cur.y] == UP) {
                    visitStack.push(new Node(cur.x - 1, cur.y));
                }else {
                    visitStack.push(new Node(cur.x, cur.y - 1));
                }
            }

            return  new ArrayList<>(lcses);
        }

        private String toList(Stack<Character> pathStack) {
            StringBuilder buffer = new StringBuilder();
            while (!pathStack.isEmpty()) {
                buffer.append(pathStack.pop());
            }
            return buffer.toString();
        }

        private void printDpRs(String s1, String s2, int[][] rs, char[][] bk) {
            for (int row = 0; row < rs.length; row++) {
                if (row == 0) {
                    continue;
                }
                for (int i = 0; i < rs[row].length; i++) {
                    if (i == 0) {
                        continue;
                    }
                    System.out.printf("%1s(%1s) ", rs[row][i], bk[row][i]);
                }
                System.out.println("");
            }
        }

    }
}
