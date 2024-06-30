package org.example.Leetcode75.C4_Prefix_Sum;

public class P2_PivotIndex {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

    private static int pivotIndex(int[] nums) {
        int left_sum = 0, right_sum = 0;

        for (int v: nums)
            right_sum = right_sum + v;

        for (int i = 0; i < nums.length; i++) {
            right_sum -= nums[i];
            if (left_sum == right_sum)
                return i;
            left_sum += nums[i];
        }

        return -1;
    }
}
