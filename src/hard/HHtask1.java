package hard;

import java.io.*;
import java.util.*;

public class HHtask1 {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int nCards = in.nextInt();
        int nPeople = in.nextInt();
        int[] a = new int[nCards];
        double sum = 0;
        int minBucks = Integer.MAX_VALUE;
        for (int i = 0; i < nCards; i++) {
            a[i] = in.nextInt();
            sum+=a[i];
            minBucks = Math.min(minBucks,a[i]);
        }
        sum = Math.floor(sum);
        int answer = 0;
        while(sum > minBucks){
            int payPeoples = 0;
            for (int i = 0; i < a.length; i++) {
                if(a[i]/sum > nPeople){
                    payPeoples++;
                }
            }
            if(payPeoples > nPeople){
                answer = (int) sum;
            }
            sum--;
        }
        out.println(answer);
    }

    public static void main(String[] args) {
        new HHtask1().run();
    }
}
