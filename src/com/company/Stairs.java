package com.company;
//https://acmp.ru/?main=task&id_task=514
import java.io.*;
import java.util.*;

public class Stairs {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int num = in.nextInt();
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            num-=i;
            cnt++;
        }
        out.println(cnt);
    }

    public static void main(String[] args) {
        new Stairs().run();
    }
}
