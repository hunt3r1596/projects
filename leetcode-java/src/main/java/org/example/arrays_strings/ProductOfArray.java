package org.example.arrays_strings;

/*
https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class ProductOfArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.println();
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;

        for (int num : nums) {
            if (num == 0)
                zeroCount++;
            else
                product = product * num;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 1)
                result[i] = 0;
            else if (nums[i] == 0)
                result[i] = product;
            else
                result[i] = (1 - zeroCount) * product / nums[i];
        }

        return result;
    }
}
