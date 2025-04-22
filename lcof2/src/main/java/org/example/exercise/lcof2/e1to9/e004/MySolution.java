package org.example.exercise.lcof2.e1to9.e004;

/**
 * @Author lin_b
 * @Date 2024/7/18 18:00
 * @Version 1.0
 * @Description TODO
 */
public class MySolution implements Solution {
    @Override
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean contain = false;
            for (int j = 0; j < nums.length; j++) {
                if(j == i) {
                    continue;
                }
                if(nums[i] == nums[j]) {
                    contain = true;
                    break;
                }
            }
            if(!contain) {
                return nums[i];
            }
        }
        return 0;
    }
}
