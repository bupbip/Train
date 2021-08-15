package com.company;

import java.io.*;
import java.util.*;

public class Cars {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int cnt = in.nextInt();
        for (int i = 0; i < cnt; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            out.println(19*m + (n + 239)*(n + 366) / 2);
        }
    }

    public static void main(String[] args) {
        new Cars().run();
    }
}
