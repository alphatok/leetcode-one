package com.nowcoder.dp;

public class LongestCommonSubstring {
    public static class Solution {
        /**
         * longest common substring (不同于 longest common sequence)
         * 画图，对角线 求子串 https://blog.csdn.net/qq_25800311/article/details/81607168
         * https://blog.csdn.net/ggdhs/article/details/90713154#t5
         *             // dp[i,j] i和j作为 共同子串后缀， 子串长度; 暂存数组
         *             // str1[i] == str2[j]   -->dp[i-1, j-1] + 1
         *             // str1[i] != str2[j]   -->0 子串必须连续
         * @param str1 string字符串 the string
         * @param str2 string字符串 the string
         * @return string字符串
         */
        public String LCS (String str1, String str2) {
            if (str1 == null || str2 == null){
                return "-1";
            }
            int len1 = str1.length();
            int len2 = str2.length();
            if (len2 == 0 || len1 == 0){
                return "-1";
            }

            int[][] rs = new int[len1][len2];
            int maxLCS = 0;
            int maxStopIndex = -1;
            for (int i = 0; i < len1; i++){
                for (int j = 0; j < len2; j++){
                    if (str1.charAt(i) == str2.charAt(j)){
                        if(i == 0 || j == 0){
                            rs[i][j] = 1;
                        }else{
                            rs[i][j] = rs[i - 1][j - 1] +1;
                        }

                        if (rs[i][j] > maxLCS){
                            maxLCS = rs[i][j];
                            maxStopIndex = i;
                        }
                    }else{
                        rs[i][j] = 0;
                    }
                }
            }

            if (maxLCS == 0){
                return "-1";
            }else{
                return str1.substring(maxStopIndex - maxLCS + 1, maxStopIndex + 1);
            }
        }

        public String LCS2(String str1, String str2) {
            if (str1 == null || str2 == null){
                return "-1";
            }
            char[] ch1 = str1.toCharArray();
            char[] ch2 = str2.toCharArray();

            if (ch2.length == 0 || ch1.length == 0){
                return "-1";
            }

            int[][] rs = new int[ch1.length + 1][ch2.length  + 1];
            int maxLCS = 0;
            int maxStopIndex = -1;
            for (int i = 0; i < ch1.length; i++){
                for (int j = 0; j < ch2.length; j++){
                    if (ch1[i] == ch2[j]){
                        rs[i + 1][j + 1] = rs[i][j] + 1; // 避免判断0

                        int tmp = rs[i + 1][j + 1];
                        if (tmp > maxLCS){
                            maxLCS = tmp;
                            maxStopIndex = i;
                        }
                    }
                }
            }

            if (maxLCS == 0){
                return "-1";
            }else{
                return str1.substring(maxStopIndex - maxLCS + 1, maxStopIndex + 1);
            }
        }
    }


}
