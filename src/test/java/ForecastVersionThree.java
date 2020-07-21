package com.cloudmqtt;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;


public class ForecastVersionThree {


    public static HttpEntity entity;


    public static void doHttpGetTwo() {

        //API AUTH &units=metric <- to celcius
        String url = "http://api.openweathermap.org/data/2.5/forecast?&units=metric&id=2172797&appid=062bae610b931929c6cfb7c5b83405f0";
        CloseableHttpClient client = HttpClients.createDefault();
        //GET REQUEST
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse resp = null;
        //JSON RESPONSE AANMAKEN, OUTPUT bij PahoDemo
        try {
            resp = client.execute(get);
            entity = resp.getEntity();



        } catch (IOException ioe) {
            System.err.println("Something went wrong getting the weather: ");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unknown error: ");
            e.printStackTrace();
        }
    }



}
