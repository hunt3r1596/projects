package org.example.Leetcode75.C5_HashMap_Set;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P3_CloseStrings {

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "bca";
        System.out.println(closeStrings(word1, word2));
    }

    private static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<Character, Long> m1 = word1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        Map<Character, Long> m2 = word2.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        if (!m1.keySet().equals(m2.keySet())) {
            return false;
        }

        Map<Long, Long> mv1 = m1.values().stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));;
        Map<Long, Long> mv2 = m2.values().stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));;

        if (!mv1.keySet().equals(mv2.keySet())) {
            return false;
        }

        List<Long> sorted1 = new ArrayList<>(m1.values());
        List<Long> sorted2 = new ArrayList<>(m2.values());

        Collections.sort(sorted1);
        Collections.sort(sorted2);

        // Check if the sorted collections are equal
        return sorted1.equals(sorted2);
    }
}
