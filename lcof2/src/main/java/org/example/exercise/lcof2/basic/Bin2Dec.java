package org.example.exercise.lcof2.basic;

/**
 * @Author lin_b
 * @Date 2024/7/29 16:22
 * @Version 1.0
 * @Description
 */
public class Bin2Dec {
    public static void main(String[] args) {
        for (int i = -5; i < 5; i++) {
            String bin = Integer.toBinaryString(i);
            if(binToDec(bin) != i) {
                System.err.println("i=" + i + ",bin=" + bin + ",out=" + binToDec(bin));
            }
        }

        /****/
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            String bin = Integer.toBinaryString(i);
            if(binToDec(bin) != i) {
                System.err.println("i=" + i + ",bin=" + bin + ",out=" + binToDec(bin));
            }
        }
        /****/
    }

    public static int binToDec(String bin) {
        int result = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (i > 0) {
                result <<= 1;
            }
            if(bin.charAt(i) == '1') {
                result |= 1;
            }
        }
        return result;
    }
}