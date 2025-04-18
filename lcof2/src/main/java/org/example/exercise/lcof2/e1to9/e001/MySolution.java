package org.example.exercise.lcof2.e1to9.e001;

/**
 * @Author lin_b
 * @Date 2024/4/10 8:30
 * @Version 1.0
 * @Description
 * 除法本质上就是减法，题目要求我们计算出两个数相除之后的取整结果，其实就是计算被除数是多少个除数加上一个小于除数的数构成的。但是一次循环只能做一次减法，效率太低会导致超时，
 * 未考虑 当被除数为 INT32_MIN 时，转换为正数时会大于 INT32_MAX。
 */
public class MySolution implements Solution {

    @Override
    public int divide(int a, int b) {
        boolean negative = (a < 0 && b >0) || (b < 0 && a > 0);
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;

        int result = 0;
        while(a >= b) {
            a = a - b;
            result ++;
        }

        return negative ? -result: result;
    }
}
