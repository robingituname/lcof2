package org.example.exercise.lcof2.e1to9.e007;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author lin_b
 * @Date 2024/7/24 18:41
 * @Version 1.0
 * @Description TODO
 */
public class Verify {
    public static void main(String[] args) {
        List<Data> list = new ArrayList<>();
        list.add(new Data(Arrays.asList(Arrays.asList(-1,-1,2), Arrays.asList(-1,0,1)), new int[]{-1,0,1,2,-1,-4}));
        list.add(new Data(Arrays.asList(), new int[]{}));
        list.add(new Data(Arrays.asList(), new int[]{0}));

        solution(list, new MySolution());

    }


    private static void solution(List<Data> list, Solution solution) {
        long time = System.currentTimeMillis();
        for (Data data : list) {
            List<List<Integer>> out = solution.threeSum(data.nums);
            if(isNotSame(out, data.out)) {
                System.out.println("error");
                System.out.println(data + ",out=" + out);
                break;
            }
        }
        System.out.println(solution.getClass().getSimpleName() + ":cost time=" + (System.currentTimeMillis() - time));
    }

    private static boolean isNotSame(List<List<Integer>> out, List<List<Integer>> out1) {
        if(out.size() != out1.size()) {
            return true;
        }
        for (int i = 0; i < out.size(); i++) {
            if(out.get(i).size() != out1.get(i).size() ) {
                return true;
            }
            for (int i1 = 0; i1 < out.get(i).size(); i1++) {
                if(!Objects.equals(out.get(i).get(i1), out1.get(i).get(i1))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Data {
        List<List<Integer>> out;
        int[] nums;

        @Override
        public String toString() {
            return "Data{" +
                    "out=" + out +
                    ", nums=" + Arrays.toString(nums) +
                    '}';
        }
    }
}
