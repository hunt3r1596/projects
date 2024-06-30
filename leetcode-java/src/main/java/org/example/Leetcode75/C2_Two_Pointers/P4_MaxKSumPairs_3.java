package org.example.Leetcode75.C2_Two_Pointers;

import java.util.Arrays;

public class P4_MaxKSumPairs_3 {

    public static void main(String[] args) {
        int[] nums = { 2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2 };
        int k = 3;
        System.out.println(maxOperations(nums, k));
    }

    private static int maxOperations(int[] nums, int k) {
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                nums[endIndex++] = nums[i];
            }
        }

        Arrays.sort(nums, 0, endIndex);

        int count = 0;

        for (int i = 0, j = endIndex - 1; i < j; ) {
            if (nums[i] + nums[j] == k) {
                count++;
                i++;
                j--;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}
