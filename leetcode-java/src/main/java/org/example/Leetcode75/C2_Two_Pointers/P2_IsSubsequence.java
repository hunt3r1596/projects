package org.example.Leetcode75.C2_Two_Pointers;

public class P2_IsSubsequence {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequenceSlower(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j))
                i++;
        }
        return (i == s.length());
    }

    private static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        while (i < s_array.length && j < t_array.length) {
            if (s_array[i] == t_array[j]) {
                i++;
                j++;
            } else
                j++;
        }
        return (i == s_array.length);
    }


}
