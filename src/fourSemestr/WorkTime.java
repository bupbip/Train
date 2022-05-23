import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WorkTime {

    private static final String REGEX = "[‘’'\\]\\[}\\{ ,;\"]";
    private static final String REGEX_TO_SPLIT = "start:|end:";
    private static final int STEP = 2;
    private static final int MILLS_TO_SEC = 1000;
    private static final int SEC_TO_MIN = 60;
    private static final int MIN_TO_HOUR = 60;
    private static final int SEC_IN_STRING_LENGTH = 3;

    private void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        String input = in.nextLine();
        input = input.replaceAll(REGEX, "");
        String[] datesWithSpacebar = input.split(REGEX_TO_SPLIT);
        Long allTimeInMills = 0L;
        for (int i = 1; i < datesWithSpacebar.length - 1; i += STEP) { // тк нулевой элемент пробел, начинаем с 1
            allTimeInMills += parseStringToDate(datesWithSpacebar[i + 1]).getTime() - parseStringToDate(datesWithSpacebar[i]).getTime();
        }
        out.printf("%d-%02d", allTimeInMills / (MILLS_TO_SEC * SEC_TO_MIN * MIN_TO_HOUR), allTimeInMills / (MILLS_TO_SEC * SEC_TO_MIN) % MIN_TO_HOUR);
    }

    private Date parseStringToDate(String strToParsing) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.M.yyyyhh:mm");
            strToParsing.substring(0, strToParsing.length() - SEC_IN_STRING_LENGTH);
            Date date = sdf.parse(strToParsing);
            return date;
        } catch (ParseException e) {
            System.out.println("Некорректная дата");
            System.exit(1);
        }
        return null;
    }

    public static void main(String[] args) {
        new WorkTime().run();
    }
}