package org.example.Leetcode75.C3_Sliding_Window;

public class P4_LongestSubOnes {

    public static void main(String[] args) {
//        int[] nums = {0,1,1,1,0,1,1,0,1};
        int[] nums = {1,1,0,0,1,1,1,0,1};
//        int[] nums = {1,1,0,1};
        System.out.println(longestOnes(nums));
    }

    private static int longestOnes(int[] nums) {
        int len = 0;
        int max_len = 0;

        int start = 0;
        int zero = -1;

        while (nums[start] == 0) {
            zero = start;
            start++;
        }

        System.out.println("Start: " + start);

        for (int i = start; i < nums.length; i++) {
            if (nums[i] == 0) {
                System.out.println("Break at " + i);
                System.out.println("Length so far: " + len);
                max_len = Math.max(len, max_len);
                len = i - zero - 1;
                zero = i;
                System.out.println("Continued length: " + len);
                System.out.println("---------------------------------");
            } else
                len++;
        }

        max_len = Math.max(len, max_len);

        if (max_len == nums.length)
            return max_len - 1;

        return max_len;
    }
}
