package org.example.Leetcode75.C5_HashMap_Set;

import java.util.*;
import java.util.stream.Collectors;

public class P1_DiffOfArrays_2 {

    public static void main(String[] args) {
        int [] nums1 = {1, 2, 3, 4, 5};
        int [] nums2 = {1, 2, 3, 4, 5, 6};
        System.out.println(findDifference(nums1, nums2));
    }

    private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<Integer> res1 = set1.stream().filter(item -> !set2.contains(item)).toList();
        List<Integer> res2 = set2.stream().filter(item -> !set1.contains(item)).toList();

        return List.of(res1, res2);
    }


}
