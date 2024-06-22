package org.example.Leetcode75.C2_Two_Pointers;

import java.util.HashMap;

public class P4_MaxKSumParis_2 {

    public static void main(String[] args) {
//        int[] nums = { 2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2 };
        int[] nums = { 3,1,3,4,3 };
        int k = 6;
        System.out.println(maxOperations(nums, k));
    }

    private static int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = k - nums[i];
            if (map.containsKey(x)) {
                count++;
                System.out.println("index: " + i  +  " --> " + map);
                if (map.get(x) > 1)
                    map.put(x, map.get(x) - 1);
                else
                    map.remove(x);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}
