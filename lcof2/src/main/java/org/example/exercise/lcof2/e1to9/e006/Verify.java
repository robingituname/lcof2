package org.example.exercise.lcof2.e1to9.e006;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lin_b
 * @Date 2024/7/24 18:16
 * @Version 1.0
 * @Description TODO
 */
public class Verify {

    public static void main(String[] args) {
        List<Data> list = new ArrayList<>();
        list.add(new Data(new int[]{1,2,4,6,10}, 8,new int[]{1,3}));
        list.add(new Data(new int[]{2,3,4}, 6,new int[]{0,2}));
        list.add(new Data(new int[]{-1,0}, -1,new int[]{0,1}));
        list.add(new Data(new int[]{2,7,11,15}, 9,new int[]{0,1}));


        solution(list, new MySolution());
        solution(list, new Solution1());

    }


    private static void solution(List<Data> list, Solution solution) {
        long time = System.currentTimeMillis();
        for (Data data : list) {
            int[] out = solution.twoSum(data.numbers, data.target);
            if(!Arrays.equals(out, data.getOut())) {
                System.out.println("error");
                System.out.println(data + ",out=" + Arrays.toString(out));
                break;
            }
        }
        System.out.println(solution.getClass().getSimpleName() + ":cost time=" + (System.currentTimeMillis() - time));
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Data {
        int[] numbers;
        int target;
        int[] out;

        @Override
        public String toString() {
            return "Data{" +
                    "numbers=" + Arrays.toString(numbers) +
                    ", target=" + target +
                    ", out=" + Arrays.toString(out) +
                    '}';
        }
    }
}
