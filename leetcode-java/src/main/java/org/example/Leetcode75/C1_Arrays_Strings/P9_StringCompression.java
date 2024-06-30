package org.example.Leetcode75.C1_Arrays_Strings;

/*

 */
public class P9_StringCompression {

    public static void main(String[] args) {
//        String input = "aabcccccaaa";
        String input = "aabbcc";
//        String input = "a";
        System.out.println(compress(input.toCharArray()));
    }

    public static int compress(char[] chars) {
        int i = 0;
        int output_index = 0;

        char match = chars[0];
        int count = 1;
        for (i = 1; i < chars.length; i++) {
            if (chars[i] == match) {
                count++;
            } else {
                chars[output_index++] = match;
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (int k = 0; k < countStr.length(); k++)
                        chars[output_index++] = countStr.charAt(k);
                }
                match = chars[i];
                count = 1;
            }
        }

        chars[output_index++] = match;
        if (count > 1) {
            String countStr = String.valueOf(count);
            for (int k = 0; k < countStr.length(); k++)
                chars[output_index++] = countStr.charAt(k);
        }

        for (int k = 0; k < output_index; k++)
            System.out.print(chars[k] + " ");

        System.out.println();
        return output_index;
    }

}
