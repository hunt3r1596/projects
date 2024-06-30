package org.example.Leetcode75.C2_Two_Pointers;

public class P1_MovingZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private static void moveZeroes(int[] nums) {
        int numZeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZeroes++;
            } else {
                int t = nums[i - numZeroes];
                nums[i - numZeroes] = nums[i];
                nums[i] = t;
            }
        }
    }
}
