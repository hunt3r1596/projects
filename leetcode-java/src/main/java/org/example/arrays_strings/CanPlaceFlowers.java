package org.example.arrays_strings;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class CanPlaceFlowers {

    public static boolean getPossiblePlaces(int[] flowerbed, int n) {
        int places = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (flowerbed.length == 1) {
                    places++;
                    flowerbed[i] = 1;
                    break;
                }
                if (i == 0) {
                    if (i + 1 < flowerbed.length && flowerbed[i + 1] == 0) {
                        places++;
                        flowerbed[i] = 1;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (i - 1 >= 0 && flowerbed[i - 1] == 0) {
                        places++;
                        flowerbed[i] = 1;
                    }
                } else {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        places++;
                        flowerbed[i] = 1;
                    }
                }
            }
        }

        return places >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {0};
        int n = 1;
        System.out.println(getPossiblePlaces(flowerbed, n));
    }
}
