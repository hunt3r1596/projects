package org.example.Leetcode75.C1_Arrays_Strings;

/*
https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class P8_TripletSubsequence {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(increasingTriplet(nums));
    }

    private static boolean increasingTriplet(int[] nums) {
        int i = 0, j = 1, k = 2;

        if (nums.length < 3)
            return false;

        if (checkCondition(nums[i], nums[j], nums[k]))
            return true;

        boolean result = false;

        while (!result && i < j && j < k) {

            if (k < nums.length - 1)
                k++;
            else if (j < nums.length - 2) {
                j++;
                k = j + 1;
            } else if (i < nums.length - 3) {
                i++;
                j = i + 1;
            } else
                break;

            if (!inValidRange(i, j, k, nums.length))
                break;

            result = checkCondition(nums[i], nums[j], nums[k]);
        }
        return result;
    }

    public static boolean checkCondition(int a, int b, int c) {
        return a < b && b < c;
    }

    public static boolean inValidRange(int i, int j, int k, int length) {
        return i < j && j < k && k < length;
    }
}
