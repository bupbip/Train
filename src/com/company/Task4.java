package com.company;

import java.io.*;
import java.util.*;

public class Task4 {

    static double comission = 0;

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            queue.add(in.nextInt());
        }
        out.printf("%.2f",sum(queue));

    }

    static double sum(Queue<Integer> queue) {
        Queue<Integer> tmp = new LinkedList<Integer>();
        while (queue.size() > 1) {
            int prev = queue.poll();
            int curr = queue.poll();
            comission += (prev + curr) * 0.05;
            tmp.add(prev + curr);
            sum(tmp);
        }
        return comission;
    }

    public static void main(String[] args) {
        new Task4().run();
    }
}
