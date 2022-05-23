package com.company;

import java.io.*;
import java.util.*;

public class task270 {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        String str = in.nextLine();
        String result = "";
        if(str.length() == 0 || str.contains("_") && !str.equals(str.toLowerCase()) || str.startsWith("_") || Character.isUpperCase(str.charAt(0)) || str.charAt(str.indexOf("_")+1)=='_') {
            out.print("Error!");
        } else{
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '_'){
                    i++;
                    result += Character.toUpperCase(str.charAt(i));
                } else if (Character.isUpperCase(str.charAt(i))){
                    result += "_" + Character.toLowerCase(str.charAt(i));
                } else {
                    result += str.charAt(i);
                }
            }
        }
        out.println(result);
    }

    public static void main(String[] args) {
        new task270().run();
    }
}
