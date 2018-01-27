package wunderground;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Wundergroundlab {
    public static void main(String[] args) {

        String sURL = "http://freegeoip.net/json/";

        URL url = null;
        try {
            url = new URL(sURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        JsonElement root1 = null;
        JsonParser jp = new JsonParser();
        try {
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            root1 = jp.parse(new InputStreamReader((InputStream)request.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String getLatLong = root1.toString();

        int lat1 = getLatLong.indexOf("latitude");
        int lat2 = getLatLong.indexOf("longitude");
        String lat = getLatLong.substring(lat1 + 10, lat2-2);

        int long1 = getLatLong.indexOf("longitude");
        int long2 = getLatLong.indexOf("metro_code");
        String lon = getLatLong.substring(long1 + 11, long2-2);

        String sURL1 = "http://forecast.weather.gov/MapClick.php?lat=" + lat + "&lon=" + lon + "&FcstType=json";

        URL url1 = null;
        try {
            url1 = new URL(sURL1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        JsonElement root2 = null;
        JsonParser jp2 = new JsonParser();
        try {
            HttpURLConnection request = (HttpURLConnection) url1.openConnection();
            request.connect();
            root2 = jp.parse(new InputStreamReader((InputStream)request.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        String weather = root2.toString();

        int time1 = weather.indexOf("startPeriodName");
        int time2 = weather.indexOf("startValidTime");
        String time = weather.substring(time1 + 18, time2-3);

        int temp1 = weather.indexOf("temperature");
        int temp2 = weather.indexOf("pop");
        String temp = weather.substring(temp1 + 14, temp2-3);

        int weat1 = weather.indexOf("weather\":[");
        int weat2 = weather.indexOf("icon");
        String weat = weather.substring(weat1 + 10, weat2-3);

        int for1 = weather.indexOf("text\":[");
        int for2 = weather.indexOf("currentobservation");
        String forc = weather.substring(for1 + 7, for2-4);

        ArrayList<String> timeA = new ArrayList<String>();

        for (String t: time.split(","))
        {
            timeA.add(t);
        }

        ArrayList<String> tempA = new ArrayList<String>();

        for (String te: temp.split(","))
        {
            tempA.add(te);
        }

        ArrayList<String> weatA = new ArrayList<String>();

        for (String w: weat.split(","))
        {
            weatA.add(w);
        }

        ArrayList<String> forA = new ArrayList<String>();

        for (String f: forc.split("\""))
        {

            if (!f.equals(",") && !f.equals(""))
            {
                forA.add(f);
            }
        }

        System.out.format("%-" + 25 + "s " + "%-" + 13 + "s " + "%-" + 47 + "s %-10s\n", "TIME", "TEMP", "WEATHER", "TEXT");

        for (int i = 0; i < timeA.size(); i++)
        {
            System.out.format("%-" + 25 + "s " + "%-" + 13 + "s " + "%-" + 47 + "s %-10s\n", timeA.get(i), tempA.get(i), weatA.get(i), forA.get(i));
        }
    }
}