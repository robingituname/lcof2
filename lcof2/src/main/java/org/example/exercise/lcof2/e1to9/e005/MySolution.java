package org.example.exercise.lcof2.e1to9.e005;

/**
 * @Author lin_b
 * @Date 2024/7/24 17:51
 * @Version 1.0
 * @Description
 */
public class MySolution implements Solution {
    @Override
    public int maxProduct(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if(isNotContain(words[i], words[j])) {
                    int val = words[i].length() * words[j].length();
                    result = result > val ? result : val;
                }
            }
        }
        return result;
    }

    private boolean isNotContain(String word, String word1) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word1.length(); j++) {
                if(word.charAt(i) == word1.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
