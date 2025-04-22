package org.example.exercise.lcof2.e1to9.e004;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author lin_b
 * @Date 2024/7/17 18:15
 * @Version 1.0
 * @Description TODO
 */
public class Verify {
    public static void main(String[] args) {


        List<Data> list = new ArrayList<>();
        list.add(new Data(3,new int[]{2,2,3,2}));
        list.add(new Data(100,new int[]{0,1,0,1,0,1,100}));
        list.add(new Data(5,new int[]{3,5,3,3}));
        for (int i = 0; i < 500; i++) {
            list.add(random());
        }


        solution(list, new MySolution());

        solution(list, new MySolution1());

        solution(list, new Solution1());

        solution(list, new Solution2());

        /**
         * MySolution:cost time=11388
         * MySolution1:cost time=1368
         * Solution1:cost time=14
         * Solution2:cost time=228
         */
    }


    private static void solution(List<Data> list, Solution solution) {
        long time = System.currentTimeMillis();
        for (Data data : list) {
            int out = solution.singleNumber(data.getIn());
            if(out != data.getOut()) {
                System.out.println("error");
                System.out.println(data + ",out=" + out);
                break;
            }
        }
        System.out.println(solution.getClass().getSimpleName() + ":cost time=" + (System.currentTimeMillis() - time));
    }

    public static Data random() {
        int length = ThreadLocalRandom.current().nextInt(1, 3 * (int) Math.pow(10, 4));
        while(length % 3 != 1) {
            length++;
        }
        int out = ThreadLocalRandom.current().nextInt();

        List<Integer> list = new ArrayList<>();
        list.add(out);
        for (int i = 1; i < length; i+=3) {
            int other = ThreadLocalRandom.current().nextInt();
            if(list.contains(other)) {
                i-=3;
                continue;
            }
            list.add(other);
            list.add(other);
            list.add(other);
        }

        Collections.shuffle(list);
        int[] in = new int[length];
        for (int i = 0; i < list.size(); i++) {
            in[i] = list.get(i);
        }
        return new Data(out, in);
    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Data{
        private int out;
        private int[] in;

        @Override
        public String toString() {
            return "Data{" +
                    "out=" + out +
//                    ", in=" + Arrays.toString(in) +
                    '}';
        }
    }
}

