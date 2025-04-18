package org.example.exercise.lcof2.e1to9.e001;

/**
 * @Author lin_b
 * @Date 2024/7/8 18:13
 * @Version 1.0
 * @Description
 * 举个例子：11 除以 3 。
 * 首先11比3大，结果至少是1，
 * 然后我让3翻倍，就是6，发现11比3翻倍后还要大，那么结果就至少是2了，
 * 那我让这个6再翻倍，得12，11不比12大，
 * 吓死我了，差点让就让刚才的最小解2也翻倍得到4了。但是我知道最终结果肯定在2和4之间。也就是说2再加上某个数，这个数是多少呢？
 * 我让11减去刚才最后一次的结果6，剩下5，我们计算5是3的几倍，也就是除法，看，递归出现了。
 *
 */
public class Solution2 implements Solution {
    @Override
    public int divide(int dividend, int divisor) {
        boolean negative = (dividend < 0 && divisor >0) || (divisor < 0 && dividend > 0);
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        if(dividend > divisor) {
            return 0;
        }
        if(divisor == -1) {
            return negative ? dividend: -dividend;
        }

        if(dividend == divisor) {
            return negative ? -1: 1;
        }


        int result = 0;
        while(dividend < divisor) {
            int cnt = 1;
            long x = divisor;// 用int会溢出
            while(dividend < x + x ) {
                cnt += cnt;
                x += x;
            }
            result += cnt;
            dividend -= x;
        }
        return negative ? -result: result;
    }
}
