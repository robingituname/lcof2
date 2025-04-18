package org.example.exercise.lcof2.e1to9.e001;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author lin_b
 * @Date 2024/4/9 18:50
 * @Version 1.0
 * @Description 验证
 */
public class Verify {
    public static void main(String[] args) {

        List<Data> list = new ArrayList<>();
        list.add(new Data(15, 2, 7));
        list.add(new Data(7, -3, -2));
        list.add(new Data(0, 1, 0));
        list.add(new Data(1, 1, 1));

        list.add(new Data(-1764405866, 1175753713, -1));
        list.add(new Data(-1828575125, -1189728042, 1));



        for (int i = 0; i < 100000000; i++) {
            list.add(random());
        }

        System.out.println("list.size():" + list.size());
        solution(list, new MySolution());

        System.out.println("list.size():" + list.size());
        solution(list, new Solution1());

        System.out.println("list.size():" + list.size());
        solution(list, new Solution2());

    }

    private static void solution(List<Data> list, Solution solution) {
        long time = System.currentTimeMillis();
        for (Data data : list) {
            int divide = solution.divide(data.getA(), data.getB());
            if(divide != data.getOut()) {
                System.out.println("error");
                System.out.println(data + ",divide=" + divide);
                break;
            }
        }
        System.out.println(solution.getClass().getSimpleName() + ":cost time=" + (System.currentTimeMillis() - time));
    }

    public static Data random(){
        int a = ThreadLocalRandom.current().nextInt();
        int b = ThreadLocalRandom.current().nextInt();
        int out = a/b;
        return new Data(a,b,out);
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class Data{
        private int a;
        private int b;
        private int out;
    }
}
