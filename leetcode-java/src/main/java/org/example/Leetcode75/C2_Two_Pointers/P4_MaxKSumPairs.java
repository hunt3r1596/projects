package org.example.Leetcode75.C2_Two_Pointers;

import java.util.Arrays;
import java.util.Collections;

public class P4_MaxKSumPairs {

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;
        System.out.println(maxOperations(nums, k));
    }

    private static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 0, end = nums.length - 1;
        int count = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > k) end--;
            else if (sum < k) start++;
            else {
                count++;
                start++;
                end--;
            }
        }
        return count;
    }
}
