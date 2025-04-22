package org.example.exercise.lcof2.e1to9.e003;

/**
 * @Author lin_b
 * @Date 2024/7/16 18:12
 * @Version 1.0
 * @Description TODO
 *
 * 2.
 * 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
 *           举例：
 *          0 = 0       1 = 1
 *          2 = 10      3 = 11
 * 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
 *
 * 另外：0 的 1 个数为 0，于是就可以根据奇偶性开始遍历计算了。
 */
public class Solution2 implements Solution {
    @Override
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if(i % 2 == 1) {//偶数的二进制最后一位为0  +1 为奇数  不进位 直接加一即可
                result[i] = result[i-1] + 1;
            } else {
                result[i] = result[i >> 1];
            }
        }
        return result;
    }
}
