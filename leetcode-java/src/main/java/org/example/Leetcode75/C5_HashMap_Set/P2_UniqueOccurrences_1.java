package org.example.Leetcode75.C5_HashMap_Set;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P2_UniqueOccurrences_1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
    }

    private static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Long> occurrences = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return occurrences.size() == new HashSet<>(occurrences.values()).size();
    }
}
