package fourSemestr;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class WorkingDays {
    private static final int WEEKEND_DAYS_NUM = 4;
    private static final int WORKING_DAYS_NUM = 1;

    private void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        SimpleDateFormat sdf = new SimpleDateFormat("d.M.yyyy");
        String input = in.nextLine();
        Calendar startDate = new GregorianCalendar();
        Calendar currentDate = new GregorianCalendar();
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.M.uuuu").withResolverStyle(ResolverStyle.STRICT);
            dateFormatter.parse(input); // проверка на валидность года
            Date date = sdf.parse(input);
            startDate.setTime(date); // переводим в Calendar, удобно добавлять дни
            currentDate.setTime(date);
            calculateDays(startDate, currentDate, sdf);
        } catch (ParseException | DateTimeParseException e) {
            System.out.println("Некорректные данные");
        }
    }

    private void calculateDays(Calendar startDate, Calendar currentDate, SimpleDateFormat sdf) {
        startDate.add(Calendar.MONTH, 1);
        startDate.add(Calendar.DATE, 1); // Если через месяц от введенного дня день попадает на рабочий, его тоже надо выводить.
        while (currentDate.before(startDate)) {
            if (currentDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                currentDate.add(Calendar.DATE, WORKING_DAYS_NUM);
            }
            System.out.println(sdf.format(currentDate.getTime()));
            currentDate.add(Calendar.DATE, WEEKEND_DAYS_NUM);
        }
    }

    public static void main(String[] args) {
        new WorkingDays().run();
    }
}