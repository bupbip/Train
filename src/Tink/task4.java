package Tink;

import java.io.*;
import java.util.*;

public class task4 {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int allEtaps = in.nextInt();
        int maxBreedEtaps = in.nextInt();
        int accum = in.nextInt();
        int[] etaps = new int[allEtaps];
        int accumNums = 0;
        int stupidAccumNums = 0;
        for (int i = 0; i < etaps.length; i++) {
            etaps[i] = in.nextInt();
        }
        //without breed

        for (int i = 0; i < etaps.length; i++) {
            stupidAccumNums += Math.ceil(etaps[i] / (float) accum);
        }

        //with breed
        int allBreeding = 0;
        int[] firstToBreed = new int[allEtaps];
        int[] numBreed = new int[allEtaps];

        for (int i = 0; i < etaps.length; i++) {
            int curr = etaps[i];
            boolean addAccum = false;
            if(curr % accum == 0) {
                accumNums += etaps[i] / accum;
            }
            else {
                for (int j = 0; j < maxBreedEtaps; j++) {
                    if (curr % accum == 0) {
                        accumNums += curr / accum;
                        addAccum = true;
                        firstToBreed[allBreeding] = i + 1;
                        numBreed[allBreeding] = j + 1;
                        allBreeding++;
                        i += j;
                        break;
                    } else {
                        curr += etaps[j + 1];
                    }
                }
                if (!addAccum) {
                    accumNums += etaps[i] / accum;
                }
            }
        }
        out.println(stupidAccumNums - accumNums);
        out.println(allBreeding);
        for (int i = 0; i < allBreeding; i++) {
            out.println(firstToBreed[i] + " " + numBreed[i]);
        }
    }



    public static void main(String[] args) {
        new task4().run();
    }
}
