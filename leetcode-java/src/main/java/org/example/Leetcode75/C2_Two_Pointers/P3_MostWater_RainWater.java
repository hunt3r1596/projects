package org.example.Leetcode75.C2_Two_Pointers;

public class P3_MostWater_RainWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max_area = 0;

        while (start <  end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            max_area = Math.max(area, max_area);

            if (height[start] < height[end])
                start++;
            else
                end--;
        }

        return max_area;
    }
}
