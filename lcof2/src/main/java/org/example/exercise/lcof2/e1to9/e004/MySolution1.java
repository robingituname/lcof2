package org.example.exercise.lcof2.e1to9.e004;

/**
 * @Author lin_b
 * @Date 2024/7/18 18:24
 * @Version 1.0
 * @Description
 * 考虑数字的二进制形式，对于出现三次的数字，各 二进制位 出现的次数都是 3 的倍数。
 * 因此，统计所有数字的各二进制位中 1 的出现次数，并对 3 求余，结果则为只出现一次的数字。
 *
 */
public class MySolution1 implements Solution {
    @Override
    public int singleNumber(int[] nums) {
        int[] bins = new int[32];
        int negative = 0;
        for (int num : nums) {
            //Integer.toBinaryString 负数时取到的是补码
            if(num < 0) {
                negative++;
                num = - num;
            }
            String bs = Integer.toBinaryString(num);
            for (int i = 0; i < bs.length(); i++) {
                if(bs.charAt(bs.length() - 1 - i) == '1') {
                    bins[31 - i] += 1;
                }
            }
        }

        StringBuilder bs = new StringBuilder();
        for (int bin : bins) {
            bs.append(bin % 3);
        }
        return negative % 3 == 0 ? Integer.parseInt(bs.toString(), 2) : -Integer.parseInt(bs.toString(), 2) ;
    }
}
