package org.example.Leetcode75.C1_Arrays_Strings;


/*
https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class P2_GreatestCommonDivisorStrings {

    public static boolean valid(String str1, String str2, int k) {
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 % k > 0 || len2 % k > 0) {
            return false;
        } else {
            String divisor = str1.substring(0, k);
            return str1.replace(divisor, "").isEmpty() && str2.replace(divisor, "").isEmpty();
        }
    }


    public static String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        for (int i = Math.min(len1, len2); i >= 1; --i) {
            if (valid(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String word1 = "ABCABC";
        String word2 = "ABC";
        System.out.println(gcdOfStrings(word1, word2));
    }
}
