package com.company;

import java.io.*;
import java.util.*;

public class Porechniy {

    static final String ACCURACY = "000";

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {

        int res = 15;
        int del = 14;
        String div = "";
        String numWord = res + ACCURACY;
        for (int i = 1; numWord.length() > 0; i++) {
            if(del*i <= Integer.parseInt(numWord.charAt(0)+"") && del*(i+1) > Integer.parseInt(numWord.charAt(0)+"")) {
                res -= Integer.parseInt(numWord.charAt(0)+"") - del*i * Math.pow(10,numWord.length()-4);
                div += i;
                numWord = res + ACCURACY;
                i = 0;
            }
//            йнцдю реае мюдн ондекхрэ 1 МЮ 14 рш онксвюеьэ уси
            if(i == 10){
                i = 0;
                if(numWord.length() == 4) div += "0,";
                for (int j = 0; j < 9; j++) {
                    int tmpNum = Integer.parseInt(numWord.substring(0,2));
                    if(del*j <= tmpNum && del*(j+1) > tmpNum) {
//                        numWord = numWord.substring(2);
                        res -= del;
                        numWord = res + ACCURACY;
                        div += j;
                        break;
                    }
                }
            }
            if(numWord.length() == 3) div += ",";
            if(numWord.charAt(0) == '0') {
                div += "0";
                numWord = numWord.substring(1);
            }
        }
        out.println("ВХЯКН: " + res + " ВЮЯРМНЕ: " + div);
    }

    public static void main(String[] args) {
        new Porechniy().run();
    }
}
