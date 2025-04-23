package org.example.exercise.lcof2.e1to9.e005;

/**
 * @Author lin_b
 * @Date 2024/7/24 18:08
 * @Version 1.0
 * @Description
 * 由于题目限定了字符串中只包含英语的小写字母，因此每个字符串可以用一个 $32$ 位整数表示，该整数的每个二进制位都是 $0$ 或 $1$，
 * 分别对应字符串的每个字母是否出现。这样一来，我们判断两个字符串是否含有相同字符，只需要将对应的整数进行按位与运算，即可得到一个新的整数，如果新的整数的二进制表示中的每一位都是 $0$，就说明两个字符串不含有相同的字符。
 */
public class Solution1 implements Solution {

    @Override
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        for (int i = 0; i < mask.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                mask[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        int result = 0;
        for (int i = 0; i < mask.length; i++) {
            for (int j = i+1; j < mask.length; j++) {
                if((mask[i] & mask[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}
