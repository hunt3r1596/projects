package org.example.Leetcode75.C3_Sliding_Window;

public class P1_MaxAvgSubArray {

    public static void main(String[] args) {
        int[] nums = {0,1,1,3,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    private static double findMaxAverage(int[] nums, int k) {
        double max_value = 0;

        for (int i = 0; i < k; i++)
            max_value += nums[i];

        double value = max_value;
        for (int i = k; i < nums.length; i++) {
            value = value + nums[i] - nums[i - k];
            max_value = Math.max(value, max_value);
        }

        return max_value / k;
    }
}
