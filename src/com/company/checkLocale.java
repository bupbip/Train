package com.company;
//https://acmp.ru/index.asp?main=task&id_task=529

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class checkLocale {

    void run() {
        Locale.setDefault(Locale.US); // точка вместо запятой
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        out.printf("%.5f",Math.sqrt(Math.pow(Math.abs(x2-x1),2)+Math.pow(Math.abs(y2-y1),2)));
    }

    public static void main(String[] args) {
        new checkLocale().run();
    }
}
