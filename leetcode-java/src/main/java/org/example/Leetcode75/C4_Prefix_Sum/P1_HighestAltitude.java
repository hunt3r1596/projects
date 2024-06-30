package org.example.Leetcode75.C4_Prefix_Sum;

public class P1_HighestAltitude {

    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain));
    }

    private static int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum = sum + gain[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
