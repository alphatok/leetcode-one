package com.algo.util;

public class StringUtil {

    /**
     * not using regex
     *
     * @param str 1; 1,2
     * @return array
     */
    public static int[] splitAsIntArray(String str){
        int count = 1;
        for (int i = 0; i <str.length(); i++) {
            if (',' == str.charAt(i)) {
                count++;
            }
        }

        int[] results = new int[count];
        int preCommaIndex = -1;
        int resultIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (',' == str.charAt(i)) {
                String intValStr = str.substring(preCommaIndex + 1, i);
                results[resultIndex++] = parseIntFromString(intValStr);
                preCommaIndex = i;
            }
        }

        // handle last value after comma
        String intValStr = str.substring(preCommaIndex + 1);
        results[resultIndex++] = parseIntFromString(intValStr);

        return results;
    }

    private static int parseIntFromString(String intValStr) {
        intValStr = intValStr.trim();
        return Integer.parseInt(intValStr, 10);
    }
}
