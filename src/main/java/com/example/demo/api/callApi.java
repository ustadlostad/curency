package com.example.demo.api;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class callApi {

    String inline;
    URL url;
    public static String usdAlis;
    public static String usdSatis;
    public static String eurAlis;
    public static String eurSatis;
    public static String guncellemeSaati;

    public void apiCall() throws IOException {

        url = new URL("https://doviz.gen.tr/doviz_json.asp");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode != 200) {
            System.out.println("Conn Err!!");
        } else {
            System.out.println("Conn Success!");

        }
    }

    public void apiData() throws JSONException, IOException {

        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext()) {

            inline = scanner.nextLine() + inline;

        }

        System.out.println(inline);
        scanner.close(); //batur

        JSONObject jsonObject = new JSONObject(inline);
        usdAlis = jsonObject.getString("dolar");
        usdSatis = jsonObject.getString("dolar2");
        eurAlis = jsonObject.getString("euro");
        eurSatis = jsonObject.getString("euro2");
        guncellemeSaati = jsonObject.getString("songuncellenme");

        System.out.println(usdAlis);
        System.out.println(usdSatis);
        System.out.println(eurAlis);
        System.out.println(eurSatis);
        System.out.println(guncellemeSaati);


    }

}
