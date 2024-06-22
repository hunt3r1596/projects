package org.example.Leetcode75.C3_Sliding_Window;

import java.util.HashSet;
import java.util.Set;

public class P2_MaxVowels {

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length() && i < k; i++) {
            if (isVowel(s.charAt(i)))
                count++;
        }

        int max_count = count;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i)))
                count++;
            if (isVowel(s.charAt(i-k)))
                count--;

            max_count = Math.max(count, max_count);
        }

        return max_count;
    }
}
