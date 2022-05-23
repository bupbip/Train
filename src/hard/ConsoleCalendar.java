package hard;

import java.text.ParseException;
import java.util.*;

enum Months{

    Январь,
    Февраль,
    Март,
    Апрель,
    Май,
    Июнь,
    Июль,
    Август,
    Сентябрь,
    Октябрь,
    Ноябрь,
    Декабрь
}

enum DaysOfWeek {
    Пн,
    Вт,
    Ср,
    Чт,
    Пт,
    Сб,
    Вс
}

public class ConsoleCalendar {
    public static void main(String[] args) throws ParseException {

//        createFile();
//        Вывод текущей даты и времени с использованием toString()
//        System.out.println(date.toString());
//        System.out.println(date.setDate(24 * 60 * 60 * 1000).toString());
//        for (int i = 1970; i < 1973; i++) {
//        for (int j = 0; j < 12; j++) {
        Map<Integer, String> dayToWeek = new HashMap<>();
        System.out.println(Months.values()[2]);
        System.out.println("  Пн  Вт  Ср  Чт  Пт  Сб  Вс");
        for (int k = 1; k <= 31; k++) {
            Calendar date = new GregorianCalendar( 2022 ,03, k);
            int rightDay = (date.get(Calendar.DAY_OF_WEEK) + 6) % 7;
            dayToWeek.put(date.get(Calendar.DAY_OF_MONTH),DaysOfWeek.values()[rightDay].toString());

//            if(k == 1) System.out.print(String.valueOf((10^(4*(rightDay+1)))).replaceAll("0"," ").replaceAll("1",""));
        }
        Set<Integer> setKeys = dayToWeek.keySet();
//        System.out.print("\t");
        for(Integer k: setKeys) {
            System.out.printf("%4d", k);
            if(dayToWeek.get(k).equals("Вс")) System.out.println("");
        }
    }
}
