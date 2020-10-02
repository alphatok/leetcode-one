package com.algo.lang;

public class MyInteger {

    int val;

    static int[] postiveSizeArray = {
            9,
            99,
            999,
            9999,
            99999,
            999999,
            9999999,
            99999999,
            999999999,
            0X7FFFFFFF, //
    };

    static int[] negativeSizeArray = {
            -9,
            -99,
            -999,
            -9999,
            -99999,
            -999999,
            -9999999,
            -99999999,
            -999999999,
            Integer.MIN_VALUE, //
    };

    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' ,
            'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z' ,
            'A' , 'B' ,
            'C' , 'D' , 'E' , 'F' , 'G' , 'H' ,
            'I' , 'J' , 'K' , 'L' , 'M' , 'N' ,
            'O' , 'P' , 'Q' , 'R' , 'S' , 'T' ,
            'U' , 'V' , 'W' , 'X' , 'Y' , 'Z' ,
    };

    public MyInteger(int val) {
        this.val = val;
    }

    public static int stringSize(int value){
        if (value > 0) {
            int i;
            for (i = 0; i < postiveSizeArray.length; i++) {
                if (postiveSizeArray[i] >= value) {
                    break;
                }
            }
            return i + 1;
        }else if (value < 0){
            int i;
            for (i = 0; i < negativeSizeArray.length; i++) {
                if (negativeSizeArray[i] <= value) {
                    break;
                }
            }
            return i + 2;
        }else{
            return 1;
        }
    }

    public String toString(){
        if (Integer.MIN_VALUE == val) {
            return "-2147483648";
        }
        StringBuilder buffer = new StringBuilder(12);
        int tmp = val > 0 ? val : -val;
        do {
            buffer.append(tmp%10);
            tmp /= 10;
        }while (tmp != 0);


        if (val < 0) {
            buffer.append("-");
        }
        return buffer.reverse().toString();
    }


    public static String toString(int value, int radix){
        if (radix < 2 || radix > 62) {
            throw new RuntimeException("exceed range");
        }
        boolean negative = value < 0;
        int tmp = value;
        if (!negative){
            tmp = -value;
        }
        char[] chars = new char[33];
        int lastIndex = 32;

        do{
            chars[lastIndex--] = digits[ -(tmp % radix)];
            tmp = tmp / radix;
        }while (tmp != 0);

        if (negative) {
            chars[lastIndex--] = '-';
        }

        int offset = lastIndex + 1;
        return new String(chars, offset, 32 - lastIndex);
    }

    /**
     *
     * @param value +8383, -9383, 99, -0098, fe
     * @param radix 2~62
     * @return radix 10
     */
    public static Integer fromValue(String value, int radix){
        char[] chs = value.toCharArray();
        int rate = 1;
        // init 0
        int val = 0;
        boolean negative = (chs[0] == '-');
        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] == '-' || chs[i] == '+'){
                break;
            }

            int charNumber = chs[i] - '0';
            // test within (chars)
            if (charNumber < 0 || charNumber > (radix-1)){
                throw new NumberFormatException("illegal character");
            }

            // validate range
            int digitalVal = charNumber * rate;
            if (negative){
                digitalVal = -digitalVal;
                if ( val < Integer.MIN_VALUE - digitalVal) {
                    throw new RuntimeException("too small");
                }
            }else{
                if ( val > Integer.MAX_VALUE - digitalVal) {
                    throw new RuntimeException("too large");
                }
            }

            val += digitalVal;
            rate *= radix;
        }

        return val;
    }

}
