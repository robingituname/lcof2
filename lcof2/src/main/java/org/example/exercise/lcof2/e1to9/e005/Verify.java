package org.example.exercise.lcof2.e1to9.e005;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lin_b
 * @Date 2024/7/24 8:36
 * @Version 1.0
 * @Description TODO
 */
public class Verify {

    public static void main(String[] args) {
        List<Data> list = new ArrayList<>();
        list.add(new Data(16,new String[]{"abcw","baz","foo","bar","fxyz","abcdef"}));
        list.add(new Data(4 ,new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
        list.add(new Data(0 ,new String[]{"a","aa","aaa","aaaa"}));

        solution(list, new MySolution());
        solution(list, new Solution1());

    }


    private static void solution(List<Data> list, Solution solution) {
        long time = System.currentTimeMillis();
        for ( Data data : list) {
            int out = solution.maxProduct(data.getWords());
            if(out != data.getOut()) {
                System.out.println("error");
                System.out.println(data + ",out=" + out);
                break;
            }
        }
        System.out.println(solution.getClass().getSimpleName() + ":cost time=" + (System.currentTimeMillis() - time));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Data {
        int out;
        String[] words;

        @Override
        public String toString() {
            return "Data{" +
                    "out=" + out +
                    ", words=" + Arrays.toString(words) +
                    '}';
        }
    }
}
