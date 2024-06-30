package org.example.Leetcode75.C5_HashMap_Set;

import java.util.ArrayList;
import java.util.List;

public class P4_EqualPairs_1 {

    public static void main(String[] args) {
        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        List<StringBuilder> rows = new ArrayList<>();
        List<StringBuilder> cols = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {

            StringBuilder r = new StringBuilder("");

            for (int j = 0; j < grid[0].length; j++) {
                String tmp = grid[i][j] + ",";
                StringBuilder s = new StringBuilder(tmp);

                if (i == 0)
                    cols.add(s);
                else
                    cols.get(j).append(s);

                r.append(s);
            }

            rows.add(r);
        }

        int count = 0;
        for (int i = 0; i < rows.size(); i++) {
            final String row = rows.get(i).toString();
            count += cols.stream().filter(x -> x.toString().equals(row)).count();
        }
        return count;
    }
}
