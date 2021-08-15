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
        for (int i = 2; currFib < num; i++) {
            if(i==1){
                prevFib = 1;
            } else {
                int tmp = currFib;
                currFib += prevFib;
                prevFib = tmp;
            }
            result = i;
        }
        if(currFib == num){
            out.println(1);
            out.print(result);
        } else {
            out.println(0);
        }
    }

    public static void main(String[] args) {
        new Fib().run();
    }
}
