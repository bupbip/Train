package com.company;
//https://acmp.ru/?main=task&id_task=79
import java.io.*;
import java.util.*;

public class LastPow {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int num = 1;
        for (int i = 0; i < b; i++) {
            num*=a;
            num%=10;
        }
        out.println(num);
    }

    public static void main(String[] args) {
        new LastPow().run();
    }
}
