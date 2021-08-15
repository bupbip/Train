package com.company;

import java.io.*;
import java.util.*;

public class Lavochki {

    public static void main(String[] args) {
        new Lavochki().run();
    }

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int answer;
        answer = n * (n - 1) / 2 * (n - 2) / 3 * (n - 3) / 4 * (n - 4) / 5 * n * (n - 1) * (n - 2) * (n - 3) * (n - 4);
        out.print(answer);
    }
}
