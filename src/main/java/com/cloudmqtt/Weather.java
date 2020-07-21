package com.cloudmqtt;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public  class Weather {

    public static HttpEntity entity;
    public static void doHttpGet() {

       String url = "http://api.openweathermap.org/data/2.5/weather?&units=metric&id=2747891&appid=062bae610b931929c6cfb7c5b83405f0";

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse resp = null;
        try {
            resp = client.execute(get);
            entity = resp.getEntity();
            //    System.out.println(EntityUtils.toString(entity));


        } catch (IOException ioe) {
            System.err.println("Something went wrong getting the weather: ");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unknown error: ");
            e.printStackTrace();
        }
    }
        }
