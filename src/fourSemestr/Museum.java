import java.io.PrintWriter;
import java.util.Scanner;

public class Museum {
    private static final int CONVERT_TIME = 60;
    private static final int MINS_IN_DAY = 1440;
    private static final int EXIT_MINS_IN_ARRAY = 3;
    private static final int EXIT_HRS_IN_ARRAY = 2;
    private static final int ENTER_MINS_IN_ARRAY = 1;
    private static final int ENTER_HRS_IN_ARRAY = 0;

    private void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        int[] peoplesInMin = new int[MINS_IN_DAY];
        String regularExpression = "^([01][0-9]|2[0-3]|[0-9]):[0-5][0-9] ([01][0-9]|2[0-3]|[0-9]):[0-5][0-9]$";
        int minTime = 0;
        int maxTime = MINS_IN_DAY;
        while (in.hasNextLine()) {
            String buffer = in.nextLine();
            if (buffer.equals("")) {
                break;
            }
            if (!buffer.matches(regularExpression)) {
                System.out.println("Дата введена неправильно");
                System.exit(1);
            }
            String[] enterAndExit = buffer.split("[ :]");
            int enter = Integer.parseInt(enterAndExit[ENTER_HRS_IN_ARRAY]) * CONVERT_TIME + Integer.parseInt(enterAndExit[ENTER_MINS_IN_ARRAY]);
            int exit = Integer.parseInt(enterAndExit[EXIT_HRS_IN_ARRAY]) * CONVERT_TIME + Integer.parseInt(enterAndExit[EXIT_MINS_IN_ARRAY]);
            while (exit > enter) {
                peoplesInMin[enter]++;
                enter++;
            }
        }

        int maxPeople = 0;
        boolean found = false;
        for (int i = 0; i < peoplesInMin.length; i++) {
            if (peoplesInMin[i] > maxPeople) {
                maxPeople = peoplesInMin[i];
                minTime = i;
                found = false;
            }
            if (peoplesInMin[i] < maxPeople && !found) {
                found = true;
                maxTime = i;
            }
        }
        out.printf("%d:%02d %d:%02d", minTime / CONVERT_TIME, minTime % CONVERT_TIME, maxTime / CONVERT_TIME, maxTime % CONVERT_TIME);
    }

    public static void main(String[] args) {
        new Museum().run();
    }
}