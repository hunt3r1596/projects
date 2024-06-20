package org.example.Leetcode75.C1_Arrays_Strings;

/*
https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class P8_TripletSubsequence_2 {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(increasingTriplet(nums));
    }

    private static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;


        for(int big : nums) {
            if(big <= small) {
                small = big;
            }
            else if(big <= mid) {
                mid = big;
            }
            else return true;
        }
        return false;
    }
}
