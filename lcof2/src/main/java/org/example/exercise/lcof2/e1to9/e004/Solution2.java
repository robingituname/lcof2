package org.example.exercise.lcof2.e1to9.e004;

/**
 * @Author lin_b
 * @Date 2024/7/22 18:11
 * @Version 1.0
 * @Description
 * MySolution2 升级版
 * 方法二：遍历统计
 * 此方法相对容易理解，但效率较低，总体推荐方法一。
 *
 * 使用 与运算 ，可获取二进制数字 num 的最右一位 num&1
 * 配合 无符号右移操作 ，可获取 num 所有位的值  num=num>>>1
 */
public class Solution2 implements Solution{
    @Override
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < counts.length; j++) {
                //获取二进制数字 num 的最右一位
                counts[j] += nums[i] & 1;
                //无符号右移
                nums[i] >>>= 1;
            }
        }

        //对 3 求余
        for (int i = 0; i < counts.length; i++) {
            counts[i] = counts[i] % 3;
        }

        //利用 左移操作 和 或运算 ，可将 counts 数组中各二进位的值恢复到数字 res 上
        int res = 0;
        for (int i = 0; i < counts.length; i++) {
            //count[i]    0/1   count[0] = 二进制最低位
            res <<= 1;
            res |= counts[31-i];
        }
        return res;
    }
}
