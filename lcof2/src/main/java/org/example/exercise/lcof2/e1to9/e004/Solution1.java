package org.example.exercise.lcof2.e1to9.e004;

/**
 * @Author lin_b
 * @Date 2024/7/22 18:11
 * @Version 1.0
 * @Description TODO 太难了 solution2 好懂
 * 方法一：有限状态自动机
 * 各二进制位的 位运算规则相同 ，因此只需考虑一位即可。对于所有数字中的某二进制位 1 的个数，存在 3 种状态，即对 3 余数为 0,1,2 。
 * 若输入二进制位 1 ，则状态按照以下顺序转换； 0→1→2→0→⋯
 * 若输入二进制位 0 ，则状态不变。
 *
 * 由于二进制只能表示 0,1 ，因此需要使用两个二进制位来表示 3 个状态。设此两位分别为 two , one ，则状态转换变为： 00→01→10→00→⋯
 *
 * -------------------------------------------
 * 回忆一下位运算特点，对于任意二进制位 x ，有：
 * 异或运算：x ^ 0 = x ， x ^ 1 = ~x
 * 与运算：x & 0 = 0 ， x & 1 = x
 * -------------------------------------------
 *
 * 计算 one 方法：
 *
 *               设当前状态为 two one ，此时输入二进制位 n (0/1)。如下图所示，通过对状态表的情况拆分，可推出 one 的计算方法为：
 *
 *               if two == 0:            // 00 01 两种  00: +0 -> 00 ,+1 -> 01  | 01: +0 -> 01  +1 -> 10  总结 +0时不变  +1时取反
 *                 if n == 0:
 *                   one = one
 *                 if n == 1:
 *                   one = ~one
 *               if two == 1:           //  只有 10  两种情况  1: +0 -> 10 ,2:+1 -> 00    总结 加啥都是0
 *                   one = 0
 *
 *               引入 异或运算 ，可将以上拆分简化为：
 *                (n == 0 : 因为 x^0 = x 所以one=one^0=one^n，   one==1 : 因为 x ^ 1 = ~x 所以 one = one^1 = one^n  所以 two==0 one=one^n)
 *
 *               if two == 0:
 *                   one = one ^ n
 *               if two == 1:
 *                   one = 0
 *
 *               引入 与运算 ，可继续简化为： (one 取值只有 0 1)
 *               (two == 0:  one ^ n & ~two == one ^ n & 0xff == one ^ n )
 *               (two == 1:  one ^ n & ~two == one ^ n & '1110' == one ^ n & '0' == 0)
 *
 *               one = one ^ n & ~two
 *  计算 two 方法：              //(00→01→10→00→⋯)  0 0 1
 *                由于是先计算 one ，因此应在新 one 的基础上计算 two 。
 *
 *                if one == 0:
 *                   if n == 0:
 *                      two = two
 *                   if n == 1:        // 1: 01 -> 10   2: 10 -> 00  总结  取反
 *                      two = ~two
 *                if one == 1
 *                   if n == 0:
 *                      two = two       //01 -> 01 two = 0
 *                  if n == 1:        // 00 -> 01
 *                      two = two      //two = 0
 *
 *                one==1时 固定值简化成0 和‘计算 one 方法’一样
 *
 *                if one == 0:
 *                   if n == 0:
 *                      two = two
 *                   if n == 1:
 *                      two = ~two
 *                if one == 1
 *                   two = 0
 *
 *               最后简化为
 *               two = two ^ n & ~one
 *
 *  返回值：
 *      以上是对数字的二进制中 “一位” 的分析，而 int 类型的其他 31 位具有相同的运算规则，因此可将以上公式直接套用在 32 位数上。
 *      遍历完所有数字后，各二进制位都处于状态 00 和状态 01 （取决于 “只出现一次的数字” 的各二进制位是 1 还是 0 ）， // (00 01 10)  三种状态 只会出现  00 或 01 (0次或一次)
 *      而此两状态是由 one 来记录的（此两状态下 twos 恒为 0 ），因此返回 ones 即可。
 *
 *
 *
 *
 */
public class Solution1 implements Solution{
    @Override
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
