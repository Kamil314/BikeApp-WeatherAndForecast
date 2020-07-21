
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public  class Weather  {

    public static HttpEntity entity;

    public static void doHttpGet() {
        //API AUTH
        String urlForecast = "http://api.openweathermap.org/data/2.5/forecast?id=2172797&appid=062bae610b931929c6cfb7c5b83405f0";
        String urlWeather = "http://api.openweathermap.org/data/2.5/weather?id=2172797&appid=062bae610b931929c6cfb7c5b83405f0";
        CloseableHttpClient client = HttpClients.createDefault();
        //GET REQUEST
        HttpGet getWeather = new HttpGet(urlWeather);
        HttpGet getForecast = new HttpGet(urlForecast);
        CloseableHttpResponse respWeather = null;
        CloseableHttpResponse respForecast = null;

        //JSON RESPONSE AANMAKEN, OUTPUT bij PahoDemo
        try {
            respWeather = client.execute(getWeather);
            entity = respWeather.getEntity();
            System.out.println("Weather has been sent to MQTT Broker in json format");
            //    System.out.println(EntityUtils.toString(entity));

            respForecast = client.execute(getForecast);
            entity = respForecast.getEntity();
            System.out.println("Forecast has been sent to MQTT Broker in json format");
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