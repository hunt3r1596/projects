package org.example.Leetcode75.C1_Arrays_Strings;

/*
https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class P2_GreatestCommonDivisorStrings_2 {

    public static String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length())
            return gcdOfStrings(str2, str1);

        if (str2.isEmpty())
            return str1;

        if (str1.startsWith(str2))
            return gcdOfStrings(str1.substring(str2.length()), str2);

        return "";
    }

    public static void main(String[] args) {
        String word1 = "ABCABC";
        String word2 = "ABC";
        System.out.println(gcdOfStrings(word1, word2));
    }
}
