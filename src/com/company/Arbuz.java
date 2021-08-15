package com.company;
//https://acmp.ru/?main=task&id_task=81
import java.io.*;
import java.util.*;

public class Arbuz {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }
        out.print(min + " " + max);
    }

    public static void main(String[] args) {
        new Arbuz().run();
    }
}
