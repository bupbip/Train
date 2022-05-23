//package com.company;
//
//import java.io.*;
//import java.util.*;
//
//public class Task6 {
//
//    void run() {
//        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
//            solve(in, out);
//        }
//    }
//
//    void solve(Scanner in, PrintWriter out) {
//        int nL = in.nextInt();
//        int[][] matrixL = new int[nL][nL];
//        for (int i = 0; i < nL - 1; i++) {
//            int x = in.nextInt();
//            int y = in.nextInt();
//            matrixL[x-1][y-1] = 1;
//            matrixL[y-1][x-1] = 1;
//        }
//        int nD = in.nextInt();
//        int[][] matrixD = new int[nD][nD];
//        for (int i = 0; i < nD - 1; i++) {
//            int x = in.nextInt();
//            int y = in.nextInt();
//            matrixD[x-1][y-1] = 1;
//            matrixD[y-1][x-1] = 1;
//        }
//        int minL = Integer.MAX_VALUE;
//        for (int i = 0; i < nL; i++) {
//            int dotConnects = 0;
//            for (int j = 0; j < nL; j++) {
//                dotConnects+=matrixL[i][j];
//            }
//            if (dotConnects > 1){
//                minL = Math.min(minL, minLen(i,matrixL));
//            }
//        }
//        int maxD = 0;
//        for (int i = 0; i < nD; i++) {
//            int dotConnects = 0;
//            for (int j = 0; j < nD; j++) {
//                dotConnects+=matrixD[i][j];
//            }
//            if(dotConnects == 1){
//                maxD = Math.max(maxD,maxLen(i,matrixD));
//            }
//        }
//    }
//
////    static int maxLen(int a, int[][] matrix){ // надо идти от одиночной к одиночной для макс длинны
////        for (int i = a + 1; i < matrix.length; i++) {
////            for (int j = 0; j < ; j++) {
////
////            }
////        }
////    }
//
//    static int minLen(int a, int[][] matrix){
//
//    }
//
//    public static void main(String[] args) {
//        new Task6().run();
//    }
//}
