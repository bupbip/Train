package Tink;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int a11, a12, a13,
                a21, a22, a23,
                a31, a32, a33;
        for (int i = 0; i <= 9; i++) {
            a11 = i;
            for (int j = 0; j <= 9; j++) {
                a12 = j;
                a13 = N - a11 - a12;
                if ((a13 >= 0) && (a13 <= 9)) {
                    for (i = 0; i <= 9; i++) {
                        a21 = i;
                        a31 = N - a21 - a11;
                        if ((a31 >= 0) && (a31 <= 9)) {
                            for (i = 0; i <= 9; i++) {
                                a22 = i;
                                a23 = N - a22 - a21;
                                if ((a23 >= 0) && (a23 <= 9)) {
                                    a32 = N - a22 - a12;
                                    if ((a32 >= 0) && (a32 <= 9)) {
                                        a33 = N - a32 - a31;
                                        if ((a33 >= 0) && (a33 <= 9)) {
                                            if ((a13 + a23 + a33) == N) {
                                                count++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

}