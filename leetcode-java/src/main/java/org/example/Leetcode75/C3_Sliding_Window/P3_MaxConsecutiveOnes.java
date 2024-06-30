package org.example.Leetcode75.C3_Sliding_Window;

public class P3_MaxConsecutiveOnes {

    public static void main(String[] args) {
//        int[] nums = {0,1,1,1,0,1,1,0,1};
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }

    private static int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        while ( k > 0 && j < nums.length) {
            if (nums[j] == 0)
                k--;
            j++;
        }

        int max_len = j - i;

        while (i < nums.length && j < nums.length) {
            if (nums[j] == 1) {
                j++;
            } else {
                max_len = Math.max(j - i, max_len);
                while ( i < nums.length && nums[i] == 1)
                    i++;
                j++;
                i++;
            }
        }

        max_len = Math.max(j - i, max_len);
        return max_len;
    }
}
