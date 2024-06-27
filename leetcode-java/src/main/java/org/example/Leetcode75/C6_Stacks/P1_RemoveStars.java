package org.example.Leetcode75.C6_Stacks;

import java.util.Stack;

public class P1_RemoveStars {

    public static void main(String[] args) {
        String s = "ab**cd";
        System.out.println(removeStars(s));
    }

    private static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if (c != '*')
                stack.push(c);
            else
                stack.pop();
        }

        char[] result = new char[stack.size()];
        int i = result.length - 1;

        while(!stack.isEmpty()){
            result[i--] = stack.pop();
        }

        return new String(result);
    }
}
