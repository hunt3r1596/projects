package org.example.Leetcode75.C1_Arrays_Strings;

/*

 */
public class P9_StringCompression_2 {

    public static void main(String[] args) {
//        String input = "aabcccccaaa";
        String input = "aabbcc";
//        String input = "a";
        System.out.println(compress(input.toCharArray()));
    }

    public static int compress(char[] chars) {
        int currentIndex = 0;
        int outputIndex = 0;
        int count = 0;
        char match = chars[0];

        while(currentIndex < chars.length) {
            if (match == chars[currentIndex])
                count++;
            else {
                chars[outputIndex++] = match;
                if (count > 1) {
                    String countString = String.valueOf(count);
                    for(int i = 0; i < countString.length(); i++)
                        chars[outputIndex++] = countString.charAt(i);
                }

                count = 1;
                match = chars[currentIndex];

            }

            currentIndex++;
        }

        chars[outputIndex++] = match;
        if (count > 1) {
            String countString = String.valueOf(count);
            for(int i = 0; i < countString.length(); i++)
                chars[outputIndex++] = countString.charAt(i);
        }

        return outputIndex;
    }

}
