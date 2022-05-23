package com.company;
//https://acmp.ru/?main=task&id_task=59
import java.io.*;
import java.util.*;

public class CountSystems {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int composition = 1;
        int sum = 0;
        int result = 0;
        for (int i = 0; n >= 1; i++) {
            result += n%k * Math.pow(10,i);
            n/=k;
        }
        out.print(result);
    }

    public static void main(String[] args) {
        new CountSystems().run();
    }
}
