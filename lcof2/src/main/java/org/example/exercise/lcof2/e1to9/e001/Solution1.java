package org.example.exercise.lcof2.e1to9.e001;

/**
 * @Author lin_b
 * @Date 2024/4/10 18:00
 * @Version 1.0
 * @Description
 * 方法一：模拟 + 快速幂
 * 可借助快速幂的思想进行优化。
 * 需要注意的是，由于题目明确要求最大只能使用 32 位有符号整数，所以需要将除数和被除数同时转换为负数进行计算。因为转换正数可能会导致溢出，如当被除数为 INT32_MIN 时，转换为正数时会大于 INT32_MAX。
 * 假设被除数为 $a$，除数为 $b$，则时间复杂度为 $O(\log a \times \log b)$，空间复杂度 $O(1)$。
 *
 * 官方解题  == Solution2
 */
public class Solution1  implements Solution {
    public int divide(int a, int b) {
        if (b == 1) {
            return a;
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (a > 0 && b > 0) || (a < 0 && b < 0);
        a = a > 0 ? -a : a;
        b = b > 0 ? -b : b;

        int ans = 0;
        while (a <= b) {
            int x = b;
            int cnt = 1;
            while (x >= (Integer.MIN_VALUE >> 1) && a <= (x << 1)) {
                x <<= 1;
                cnt <<= 1;
            }
            ans += cnt;
            a -= x;
        }
        return sign ? ans : -ans;
    }
}
