package com.Lumpy;

public class StringUtils {

    public static int[] string2Integer(String string, int length) {
        String[] temp = string.split(" ");
        int result[] = new int[length];
        for (int count = 0; count < length; count++) {
            result[count] = Integer.valueOf(temp[count]);
        }
        return result;
    }
}
