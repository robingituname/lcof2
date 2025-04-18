package org.example.exercise.lcof2.basic;

import java.util.Arrays;

/**
 * @Author lin_b
 * @Date 2024/7/29 16:22
 * @Version 1.0
 * @Description 十进制转二进制
 *
 * 无符号右移操作 ，可获取 num 所有位的值  num=num>>>1
 */
public class Dec2Bin {

    public static void main(String[] args) {
        for (int i = -5; i < 5; i++) {
            System.out.println("dec=" + String.format("%05d", i) + ",bin=" + Arrays.toString(dec2bin(i)));
            System.out.println("dec=" + String.format("%05d", i) + ",bin=" + dec2binStr(i));
            System.out.println("dec=" + String.format("%05d", i) + ",bin=" + dec2binSimpleStr(i));
            System.out.println("dec=" + String.format("%05d", i) + ",bin=" + Integer.toBinaryString(i));
        }

        /****/
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            if(!dec2binSimpleStr(i).equals(Integer.toBinaryString(i))) {
                System.err.println("i=" + i + ",dec2binSimpleStr=" + dec2binSimpleStr(i) + ",toBinaryString=" + Integer.toBinaryString(i));
                break;
            }
        }
        /****/
    }

    /**
     * dec=00001,bin=[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
     */
    public static int[] dec2bin(int in) {
        int[] array = new int[32];
        int index = 31;
        while(index >= 0) {
            array[index--] = (in & 1) == 1 ? 1 : 0;
            in >>>= 1;
        }
        return array;
    }

    /**
     * dec=00001,bin=00000000000000000000000000000001
     */
    public static String dec2binStr(int in) {
        StringBuilder result = new StringBuilder();
        int[] array = dec2bin(in);
        for (int i : array) {
            result.append(i);
        }
        return result.toString();
    }

    /**
     * dec=00007,bin=111
     */
    public static String dec2binSimpleStr(int in) {
        StringBuilder result = new StringBuilder();
        int[] array = dec2bin(in);
        boolean add = false;
        for (int i : array) {
            if(!add && i == 1) {
                add = true;
            }
            if(add) {
                result.append(i);
            }
        }
        if(result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }
}
