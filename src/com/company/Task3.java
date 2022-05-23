package com.company;

import java.io.*;
import java.util.*;

public class Task3 {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        String str = in.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(" "); // делимость на 1
        if (str.charAt(str.length() - 1) != '*') {
            int num = Integer.parseInt(String.valueOf(str.charAt(str.length() - 1))); // проверка на 2
            if (num % 2 == 0) {
                sb.append(2).append(" ");
            }
            if (str.indexOf("*") < str.length() - 2) {
                if (Integer.parseInt(str.substring(str.length() - 2, str.length())) % 4 == 0) { // проверка на 4
                    sb.append(4).append(" ");
                }
            }
            if (num == 0 || num == 5) {
                sb.append(5).append(" ");
            }
            if (str.indexOf("*") < str.length() - 3) { // проверка на 8
                if (Integer.parseInt(str.substring(str.length() - 3, str.length())) % 8 == 0) {
                    sb.append(8).append(" ");
                }
            }
            if (num == 0) {
                sb.append(10).append(" ");
            }
        }
        out.print(sb.toString());
    }

    public static void main(String[] args) {
        new Task3().run();
    }
}