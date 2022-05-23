package com.company;

import java.io.*;
import java.util.*;

public class tink1 {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        out.println(a+b);
    }

    public static void main(String[] args) {
        new tink1().run();
    }
}
