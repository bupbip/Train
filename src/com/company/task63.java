package com.company;

import java.io.*;
import java.util.*;

public class task63 {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int[] a = new int[]{4,1};
        int[] b = new int[]{9,9,9,8,1};
        int[] c;
        if(a[0]+b[0]>=10) {
            c = new int[Math.max(a.length, b.length) + 1];
        } else{
            c = new int[Math.max(a.length,b.length)];
        }
        for (int i = 0; i < Math.min(a.length,b.length); i++) {
            int x = a[a.length - 1 - i];
            int y = b[b.length - 1 - i];
            if(x+y >= 10) {
                c[c.length - 2 - i]++;
                x -= 10;
            }
            c[c.length-1-i] += x + y;
        }

        for (int i = Math.min(a.length,b.length); i < Math.max(a.length,b.length); i++) {
            c[c.length - 2 - i]++;
            if (a.length > b.length && c[c.length - 1 - i] + a[a.length - i - 1] >= 10) {
                a[a.length - 1 - i] -= 10;
                c[c.length - 1 - i] += a[a.length - 1 - i];
            } else if (a.length < b.length && c[c.length - i - 1] + b[b.length - i - 1] >= 10) {

                c[c.length - 1 - i]--;
            }
        }
        out.println(Arrays.toString(c));
    }

    public static void main(String[] args) {
        new task63().run();
    }
}
