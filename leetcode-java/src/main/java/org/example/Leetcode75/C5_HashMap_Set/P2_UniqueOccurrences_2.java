package org.example.Leetcode75.C5_HashMap_Set;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P2_UniqueOccurrences_2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
    }

    private static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        return map.size() == new HashSet<>(map.values()).size();
    }
}
