package org.example.exercise.lcof2.e1to9.e003;

/**
 * @Author lin_b
 * @Date 2024/7/16 18:12
 * @Version 1.0
 * @Description TODO
 *
 * ******************************
 * 1.
 * x & (x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0
 *
 * x=2
 *
 * x&(x-1) = 0010 & 0001 0000
 *
 * x = 5     0101 0100   0100
 *
 * x = 4     0100  0011    0000
 * ******************************
 */
public class Solution1 implements Solution {
    @Override
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            for (int x = i; x > 0 ; x = x & (x - 1)) {
                result[i] += 1;
            }
        }
        return result;
    }
}
