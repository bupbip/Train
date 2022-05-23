package com.company;

import java.io.*;
import java.util.*;

public class Task2 {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int w = in.nextInt();
        int h = in.nextInt();
        int bestPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int tmpW = in.nextInt();
            int tmpH = in.nextInt();
            int currPrice = in.nextInt();
            if(tmpW >= w && tmpH >= h || tmpW >= h && tmpH >= w){
                bestPrice = Math.min(bestPrice, currPrice);
            }
        }
        out.println(bestPrice);
    }

    public static void main(String[] args) {
        new Task2().run();
    }
}
