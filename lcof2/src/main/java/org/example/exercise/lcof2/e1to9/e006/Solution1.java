package org.example.exercise.lcof2.e1to9.e006;

/**
 * @Author lin_b
 * @Date 2024/7/24 18:36
 * @Version 1.0
 * @Description TODO
 * 从 缩减搜索空间 的角度思考这个解法
 */
public class Solution1 implements Solution{

    @Override
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length -1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum > target) {
                j--;
            } else if(sum < target) {
                i++;
            } else {
                return new int[]{i,j};
            }
        }
        return new int[0];
    }
}
