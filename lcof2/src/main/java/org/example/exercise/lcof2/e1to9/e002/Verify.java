package org.example.exercise.lcof2.e1to9.e002;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author lin_b
 * @Date 2024/7/12 18:03
 * @Version 1.0
 * @Description TODO
 */
public class Verify {
    public static void main(String[] args) {
        List<Data> list = new ArrayList<>();
        list.add(new Data("11","1","100"));
        list.add(new Data("1010","1011","10101"));
        list.add(new Data("1001101010001010000111001011000", "100111111000110001100110011101", "1110101001010000010011111110101"));
        for (int i = 0; i < 100000; i++) {
            list.add(random());
        }



        solution(list, new MySolution());
    }

    private static void solution(List<Data> list, Solution solution) {
        long time = System.currentTimeMillis();
        for (Data data : list) {
            String divide = solution.addBinary(data.getA(), data.getB());
            if(!divide.equals(data.getOut())) {
                System.out.println("error");
                System.out.println(data + ",divide=" + divide);
                break;
            }
        }
        System.out.println(solution.getClass().getSimpleName() + ":cost time=" + (System.currentTimeMillis() - time));
    }

    private static Data random() {
        int a = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
        int b = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
        long o = a + b;
        if(o < 0) {
            return random();
        }
        return new Data(Integer.toString(a, 2), Integer.toString(b, 2), Long.toString(o, 2));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class Data{
        private String a;
        private String b;
        private String out;
    }
}
