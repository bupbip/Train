package com.company;

import java.io.*;
import java.util.*;

public class Task1 {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        out.println(Math.min(a+b,n));
    }

    public static void main(String[] args) {
        new Task1().run();
    }
}
