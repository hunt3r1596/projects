package org.example.Leetcode75.C5_HashMap_Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1_DiffOfArrays_1 {

    public static void main(String[] args) {
        int [] nums1 = {1, 2, 3, 4, 5};
        int [] nums2 = {1, 2, 3, 4, 5, 6};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> s1 = addToSet(nums1);
        Set<Integer> s2 = addToSet(nums2);

        Set<Integer> diff1 = new HashSet<>(s1);
        diff1.removeAll(s2);

        Set<Integer> diff2 = new HashSet<>(s2);
        diff2.removeAll(s1);

        return List.of(new ArrayList<>(diff1), new ArrayList<>(diff2));

    }

    private static Set<Integer> addToSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int v: arr) {
            set.add(v);
        }
        return set;
    }
}
