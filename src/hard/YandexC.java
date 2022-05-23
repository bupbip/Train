package hard;

import java.io.*;
import java.util.*;

public class YandexC {

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        Calendar calendar = new GregorianCalendar();
//        int t = in.nextInt();
//        int e = in.nextInt();
//        in.next();
//        while (in.hasNextLine()) {
//            String[] input = in.nextLine().split("[\\[\\]]");
//            String[] date = input[1].split("[- :]");
//            calendar.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]), Integer.parseInt(date[3]), Integer.parseInt(date[4]), Integer.parseInt(date[5]));
//            out.print(calendar.getTime()+"\n");
//        }
        String line = in.nextLine();
        while(line.length()>0){
            String[] input = line.split("[\\[\\]]");
            String[] date = input[1].split("[- :]");
            calendar.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]), Integer.parseInt(date[3]), Integer.parseInt(date[4]), Integer.parseInt(date[5]));
            out.print(calendar.getTime()+"\n");
            line = in.nextLine();
        }
    }

    public static void main(String[] args) {
        new YandexC().run();
    }
}
