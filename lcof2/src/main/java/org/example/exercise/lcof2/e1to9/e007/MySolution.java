package org.example.exercise.lcof2.e1to9.e007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lin_b
 * @Date 2024/7/24 18:47
 * @Version 1.0
 * @Description 先排序
 */
public class MySolution implements Solution {
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

//        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        for (int k = 0; k < nums.length; k++) {
            if(k > 0 && (nums[k] == nums[k-1])) {
                break;
            }
            if(nums[k] > 0) {
                break;
            }
            for (int i = k + 1; i < nums.length; i++) {
                if(nums[k] + nums[i] > 0) {
                    break;
                }
                for (int j = i +1; j < nums.length; j++) {
                    int val = nums[k] + nums[i] + nums[j];
                    if(val > 0) {
                        break;
                    }
                    if(val == 0) {
//                        System.out.println(Arrays.asList(k,i,j));
                        result.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    }
                }
            }
        }
        return result;
    }
}
