package com.company;
//https://acmp.ru/?main=task&id_task=246
import java.io.*;
import java.util.*;

public class Vans {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int curr = in.nextInt();
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int next = in.nextInt();
            if (next - curr != 1){
                cnt++;
            }
            curr = next;
        }
        out.print(cnt);
    }

    public static void main(String[] args) {
        new Vans().run();
    }
}
