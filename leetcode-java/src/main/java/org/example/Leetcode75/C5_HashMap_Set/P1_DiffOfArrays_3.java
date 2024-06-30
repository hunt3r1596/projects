package org.example.Leetcode75.C5_HashMap_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P1_DiffOfArrays_3 {

    public static void main(String[] args) {
int [] nums1 = {1, 2, 3, 4, 5};
        int [] nums2 = {1, 2, 3, 4, 5, 6};
        System.out.println(findDifference(nums1, nums2));
    }

    private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<Integer> res1 = new ArrayList<>();

        for (Integer item: set1) {
            if (set2.contains(item)) {
                set2.remove(item);
            } else {
                res1.add(item);
            }
        }

        return List.of(res1, new ArrayList<>(set2));
    }
}
