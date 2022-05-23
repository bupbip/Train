package garden;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Document getPage(String url) throws IOException{
        return Jsoup.connect(url).get();
    }

    public static void main(String[] args) throws IOException {
        String urlString = "https://world-weather.ru/pogoda/russia/moscow/march-2022/";
        ArrayList<String> celsius = new ArrayList<String>();
        ArrayList<String> weather = new ArrayList<String>();

        Document page = getPage(urlString);

        Elements weatherDays = page.getElementsByClass("ww-month");
        String[] forecast = page.select(".ww-month").toString().split("=");
        String[] monthWeather = weatherDays.text().split(" ");
        int dayNum = 1;
        for (int i = 0; i < monthWeather.length; i += 2) {
            if(monthWeather[i].matches(dayNum + ".+")){
                celsius.add(monthWeather[i].replace(dayNum+"",""));
                dayNum++;
            }
        }

        for (int i = 0; i < forecast.length; i++) {
            if(forecast[i].endsWith("title")){
                weather.add(forecast[i+1].replace(" class",""));
            }
        }

        System.out.println(celsius);
        System.out.println(weather);
    }
}