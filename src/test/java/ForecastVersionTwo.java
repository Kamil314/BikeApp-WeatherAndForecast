

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;


import java.io.IOException;
import java.sql.CallableStatement;


public class ForecastVersionTwo {


    public static JSONObject obj_JSONObject4;
    public static HttpEntity entity;

    HttpEntity entity2  =  (HttpEntity) obj_JSONObject4;


    public static void Forecast() {

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
            System.out.println("Forecast being pulled from Forecast API");
            //System.out.println(EntityUtils.toString(entity));
            System.out.println("Getting forecast...please wait");
            JSONObject obj_JSONObject  = new JSONObject(EntityUtils.toString(entity));
            JSONArray obj_JSONArray=obj_JSONObject.getJSONArray("list");
            // System.out.println(obj_JSONArray);
            //  System.out.println("--" + obj_JSONArray.length());
            JSONObject obj_JSONObject2  = obj_JSONArray.getJSONObject(1);
            JSONObject obj_JSONObject3  = obj_JSONObject2.getJSONObject("main");
            //raw value onderaan die is opgeslagen in String obj_JSONObject4.
            String obj_JSONObject4  = (("Tommorows temperature: "+obj_JSONObject3.getString( "temp") + ("°C")));
            //System.out.println(obj_JSONObject4); // value opgeslagen in een string en vervolgens geprint

            // System.out.println((("Tommorows temperature: "+obj_JSONObject3.getString( "temp") + ("°C"))));



          /*  ArrayList list = new ArrayList();
            list.add(("list- "+obj_JSONObject.getString( "list")));
            System.out.println(list);
            if  (list.contains(("weather"))) {
                System.out.println("contains weather");
            }else{
                System.out.println("It doesn't contain weather");
            }
*/


            // System.out.println("list- "+obj_JSONObject.getString( "list")); //38 times?
            // System.out.println("list- "+obj_JSONObject.getString( "list")); //38 times?




        } catch (IOException ioe) {
            System.err.println("Something went wrong getting the weather: ");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unknown error: ");
            e.printStackTrace();
        }
    }



}
