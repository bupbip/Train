package Tink;

import java.io.*;
import java.util.*;

public class task2 {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        final int GLASSES_NUM = 10;
        int[] glasses = new int[GLASSES_NUM];
        int allCola = 0;
        for (int i = 0; i < GLASSES_NUM; i++) {
            glasses[i] = in.nextInt();
            allCola += glasses[i];
        }
        int steps = 0;
        for (int i = 0; i < GLASSES_NUM; i++) {
            if(allCola/GLASSES_NUM < glasses[i]){
                steps++;
            }
        }
        out.print(steps);
    }

    public static void main(String[] args) {
        new task2().run();
    }
}
