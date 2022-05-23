package com.company;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class FibEffective {

    void run() {
        Locale.setDefault(Locale.US); // точка вместо запятой
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        out.print(fibEffective(n));
    }
//    static int fib(int n) {
//        if(n <= 1){
//            return n;
//        }
//        return(fib(n-1)+ fib(n-2));
//    }

    static long fibEffective(int n){
        long[] arr = new long[n+1];

        arr[0]= 0;
        arr[1]= 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        new FibEffective().run();
    }
}