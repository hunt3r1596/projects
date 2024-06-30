package org.example.Leetcode75.C1_Arrays_Strings;

import java.util.*;

/*
https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class P3_GreatestNumberOfCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> canHaveMax = new ArrayList<>();

        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(candy, maxCandies);
        }

        for (int i = 0; i < candies.length; i++) {
            canHaveMax.add(candies[i] + extraCandies >= maxCandies);
        }

        return canHaveMax;
    }

    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }
}
