package org.example.Leetcode75.C5_HashMap_Set;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P4_EqualPairs_2 {

    public static void main(String[] args) {
        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        Map<String, Integer> counts = new HashMap<>();
        for (int[] row : grid) {
            counts.merge(Arrays.toString(row), 1, Integer::sum);
        }

        int pairs = 0;

        for (int i = 0; i < grid.length; i++) {

            int[] col = new int[grid.length];
            for (int r = 0; r < grid.length; ++r) {
                col[r] = grid[r][i];
            }

            pairs += counts.getOrDefault(Arrays.toString(col), 0);
        }

        return pairs;
    }
}
