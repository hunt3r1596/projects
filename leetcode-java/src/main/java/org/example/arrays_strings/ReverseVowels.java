package org.example.arrays_strings;

/*
https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class ReverseVowels {

    public static String reverseVowels(String word) {
        String vowels = "aeiouAEIOU";
        char[] wordArray = word.toCharArray();
        int i = 0;
        int j = word.length() - 1;

        while (i < j) {
            while (i < j && vowels.indexOf(wordArray[i]) == -1) {
                i++;
            }
            while (i < j && vowels.indexOf(wordArray[j]) == -1) {
                j--;
            }
            char temp = wordArray[i];
            wordArray[i] = wordArray[j];
            wordArray[j] = temp;
            i++;
            j--;
        }

        return new String(wordArray);
    }

    public static void main(String[] args) {
        String word = "hello";
        System.out.println(reverseVowels(word));
    }
}
