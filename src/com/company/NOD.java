package com.company;
//https://acmp.ru/?main=task&id_task=148

import java.io.*;
import java.util.*;

public class NOD {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int A = in.nextInt();
        int B = in.nextInt();
        out.print(NOD(A, B));
    }

    int NOD(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        if (a > b) return NOD(a % b, b);
        else return NOD(a, b % a);
    }

    public static void main(String[] args) {
        new NOD().run();
    }
}
