package org.example.exercise.lcof2.e1to9.e006;

/**
 * @Author lin_b
 * @Date 2024/7/24 18:22
 * @Version 1.0
 * @Description TODO
 */
public class MySolution implements Solution {
    @Override
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
