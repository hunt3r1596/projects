package org.example.Leetcode75.C7_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class P1_RecentCalls {

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
    }
}


class RecentCounter {

    int window = 3000;
    Queue<Integer> queue = new LinkedList<>();

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);

        int span = t - window;
        while (!queue.isEmpty() && queue.peek() < span) {
            queue.poll();
        }

        return queue.size();
    }
}
