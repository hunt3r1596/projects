package org.example.Leetcode75.C6_Stacks;

import java.util.Arrays;
import java.util.Stack;

public class P2_AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        int[] result = asteroidCollision(asteroids);
        System.out.print(Arrays.toString(result));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int x: asteroids) {
            if (x > 0 || stack.isEmpty())
                stack.push(x);
            else {
                int p = stack.peek();
                boolean destroyed = false;

                while (!stack.isEmpty() && p > 0) {
                    if (p + x < 0)
                        stack.pop();
                    else {
                        if (p + x == 0) {
                            stack.pop();
                        }
                        destroyed = true;
                        break;
                    }


                    if (!stack.isEmpty())
                        p = stack.peek();
                }

                if (!destroyed)
                    stack.push(x);
            }
        }

        int res[] = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);
        }

        return res;
    }
}
