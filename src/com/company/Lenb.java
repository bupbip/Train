package com.company;
//https://acmp.ru/?main=task&id_task=694
import java.io.*;
import java.util.*;

public class Lenb {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int max = 1;
        int min = 31;
        for (int i = 0; i < N; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            max = Math.max(max, a);
            min = Math.min(min, b);
        }
        if (max<=min){
            out.print("YES");
        } else {
            out.print("NO");
        }
    }

    public static void main(String[] args) {
        new Lenb().run();
    }
}
