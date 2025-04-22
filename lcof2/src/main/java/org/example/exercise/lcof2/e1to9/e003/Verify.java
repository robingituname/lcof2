package org.example.exercise.lcof2.e1to9.e003;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author lin_b
 * @Date 2024/7/16 17:52
 * @Version 1.0
 * @Description TODO
 */
public class Verify {
    public static void main(String[] args) {
        List<Data> list = new ArrayList<>();
        list.add(new Data(2,new int[]{0,1,1}));
        list.add(new Data(5,new int[]{0,1,1,2,1,2}));
        for (int i = 0; i < 2000; i++) {
            list.add(random());
        }
        System.out.println("add completed");

        solution(list, new Solution1());
        solution(list, new Solution2());
        solution(list, new MySolution());
    }



    private static void solution(List<Data> list, Solution solution) {
        long time = System.currentTimeMillis();
        for (Data data : list) {
            int[] out = solution.countBits(data.getN());
            if(!Arrays.equals(out, data.getOut())) {
                System.out.println("error");
                System.out.println(data + ",divide=" + Arrays.toString(out));
                break;
            }
        }
        System.out.println(solution.getClass().getSimpleName() + ":cost time=" + (System.currentTimeMillis() - time));
    }

    public static Data random() {
        int n = ThreadLocalRandom.current().nextInt(0, (int) Math.pow(10, 5));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            String binaryStr = Integer.toBinaryString(i);
            int cnt = 0;
            for (int j = 0; j < binaryStr.length(); j++) {
                if(binaryStr.charAt(j) == '1') {
                    cnt ++;
                }
            }
            list.add(cnt);
        }
        int[] o = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            o[i] = list.get(i);
        }
        return new Data(n, o);
    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Data{
        private int n;
        private int[] out;

        @Override
        public String toString() {
            return "Data{" +
                    "n=" + n +
                    ", out=" + Arrays.toString(out) +
                    '}';
        }
    }
}
