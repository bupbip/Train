package com.company;
//https://acmp.ru/?main=task&id_task=496

import java.io.*;
import java.util.*;

public class Berries {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int one = in.nextInt();
        int first = one;
        int two = in.nextInt();
        int second = two;
        int maxSum = 0;
        int nEw = 0;
        for (int i = 0; i < n - 2; i++) {
            nEw = in.nextInt();
            maxSum = Math.max(one + two + nEw, maxSum);
            one = two;
            two = nEw;
        }
        maxSum = Math.max(one + nEw + first, maxSum);
        maxSum = Math.max(nEw + first + second, maxSum);
        out.println(maxSum);
    }

    public static void main(String[] args) {
        new Berries().run();
    }
}
