package com.company;
//https://acmp.ru/?main=task&id_task=271
import java.io.*;
import java.util.*;

public class Fib {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int num = in.nextInt();
        int currFib = 1;
        int prevFib = 0;
        int result = 0;
        String fibStr = "1";
        for (int i = 0; i < 10; i++) {
            int tmp = currFib;
            currFib += prevFib;
            prevFib = tmp;
            fibStr += currFib;
        }
        System.out.print(fibStr.charAt(num-1));
    }

    public static void main(String[] args) {
        new Fib().run();
    }
}
