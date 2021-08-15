package com.company;
//https://acmp.ru/?main=task&id_task=15
import java.io.*;
import java.util.*;

public class Roads {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int cnt = 0;
        for (int i = 0; i < n * n; i++) {
            int num = in.nextInt();
            cnt += num;
        }
        out.print(cnt/2);
    }

    public static void main(String[] args) {
        new Roads().run();
    }
}
