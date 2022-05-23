package Tink;

import java.io.*;
import java.util.*;

public class task1 {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int allGrams = in.nextInt();
        int workPiece = in.nextInt();
        int coinGram = in.nextInt();
        int allCoins = 0;
        while(allGrams >= workPiece){
            int newCoins = 0;
            allGrams -= workPiece;
            newCoins += workPiece / coinGram;
            allGrams += workPiece - newCoins*coinGram;
            allCoins += newCoins;
        }
        out.print(allCoins);
    }

    public static void main(String[] args) {
        new task1().run();
    }
}
