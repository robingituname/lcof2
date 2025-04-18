package org.example.exercise.lcof2.e1to9.e002;

/**
 * @Author lin_b
 * @Date 2024/7/12 17:57
 * @Version 1.0
 * @Description TODO
 */
public class MySolution implements Solution {
    @Override
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        boolean increment = false;
        for (int ai = a.length()-1,  bi = b.length() -1; ai >= 0 || bi >= 0 ; ai--, bi--) {
            int curr = 0;
            curr += increment ? 1 : 0;
            curr += ai >=0 ? a.charAt(ai) -'0':0;
            curr += bi >=0 ? b.charAt(bi) -'0':0;
            result.insert(0, curr%2);
            increment = curr >= 2;
        }
        result.insert(0, increment ? "1":"");
        return result.toString();
    }
}
