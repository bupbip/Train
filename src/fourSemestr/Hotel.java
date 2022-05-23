import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Date;
import java.util.GregorianCalendar;

public class Hotel {
    private static final String REGEX = "[\\[\\]'\"]";

    private void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        String booked = in.nextLine();
        String newStringDate = in.nextLine();
        String[] bookedStringDates = booked.replaceAll(REGEX, "").split(",");
        Set<Calendar> bookedDates = new LinkedHashSet<>();
        for (int i = 0; i < bookedStringDates.length; i++) {
            if (bookedStringDates[i].contains("-")) {
                addToBookedDays(bookedStringDates[i], bookedDates);
            } else {
                bookedDates.add(parseStringToCalendar(bookedStringDates[i]));
            }
        }
        final int bookedDays = bookedDates.size();
        int needsToAdd = 1;
        if (newStringDate.contains("-")) {
            needsToAdd = addToBookedDays(newStringDate, bookedDates); // записываем сколько дат должно добавится
        } else {
            bookedDates.add(parseStringToCalendar(newStringDate));
        }
        final int updatedBookedDays = bookedDates.size();
        System.out.println(updatedBookedDays - bookedDays == needsToAdd);
    }

    private Calendar parseStringToCalendar(String strToParsing) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date tmp = sdf.parse(strToParsing);
            Calendar cal = new GregorianCalendar();
            cal.setTime(tmp);
            return cal;
        } catch (ParseException e) {
            System.out.println("Некорректная дата");
            System.exit(1);
        }
        return null;
    }

    private int addToBookedDays(String stringDate, Set<Calendar> bookedDates) {
        String[] muchDates = stringDate.split("-");
        Calendar startNewBooking = parseStringToCalendar(muchDates[0]);
        Calendar endNewBooking = parseStringToCalendar(muchDates[1]);
        while (startNewBooking.before(endNewBooking)) {
            bookedDates.add(startNewBooking);
            startNewBooking.add(Calendar.DATE, 1);
        }
        return muchDates.length;
    }
    public static void main(String[] args) {
        new Hotel().run();
    }
}