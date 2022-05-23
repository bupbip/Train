package Tink;

import java.io.*;
import java.util.*;

public class task228 {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int cost = in.nextInt();
        int standartV = in.nextInt();
        int overPrice = in.nextInt();
        int V = in.nextInt();
        int pereplata = Math.max(0,(V - standartV) * overPrice);
        out.print(cost + pereplata);
    }

    public static void main(String[] args) {
        new task228().run();
    }
}
