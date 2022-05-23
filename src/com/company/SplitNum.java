package com.company;
//https://acmp.ru/?main=task&id_task=276

import java.io.*;
import java.util.*;

public class SplitNum {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int mid = a / b;
        while (a != mid && a != mid + 1 && a != mid - 1) {
            out.println(mid);
            a -= mid;
        }
        out.println(a);
    }

    public static void main(String[] args) {
        new SplitNum().run();
    }
}
