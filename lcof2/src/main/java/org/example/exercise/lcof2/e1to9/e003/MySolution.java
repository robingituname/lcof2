package org.example.exercise.lcof2.e1to9.e003;

/**
 * @Author lin_b
 * @Date 2024/7/16 18:12
 * @Version 1.0
 * @Description TODO
 *

 */
public class MySolution implements Solution {
    @Override
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if(i % 2 == 1) {//偶数的二进制最后一位为0  +1 为奇数  不进位 直接加一即可
                result[i] = result[i-1] + 1;
            } else {
                int cnt = 0;
                for (int val = i; val > 0 ; val = val >> 1) {
                    cnt += (val & 1) == 1 ? 1 : 0;
                }
                result[i] = cnt;
            }
        }
        return result;
    }
}
