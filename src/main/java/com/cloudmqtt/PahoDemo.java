package com.cloudmqtt;

import org.apache.http.util.EntityUtils;
import org.eclipse.paho.client.mqttv3.*;

import java.io.IOException;
import java.util.UUID;

public class PahoDemo implements MqttCallback {

    Weather weather;
    MqttClient client;
    Forecast forecast;
    private IMqttClient clientWeather;
    private IMqttClient clientForecast;
    private String userID = UUID.randomUUID().toString();
    private String clientID = userID;
    private String userID1 = UUID.randomUUID().toString();
    private String clientID1 = userID;



    public  void PublishWeather() throws InterruptedException {


            try {

                //connectie met mqtt client
                clientWeather = new MqttClient("tcp://127.0.0.1:1883", clientID);
                clientWeather.connect();
              // clientWeather.subscribe("saveLocation"); //locations
                clientWeather.setCallback(this);
                MqttMessage messageClientOne = new MqttMessage();
                messageClientOne.setPayload(EntityUtils.toString(Weather.entity)
                        .getBytes());
                //lijn 39 publisht the message naar saveWeather topic
                System.out.println("Reading Weather API...please wait");
                System.out.println("Sending Data to chosen topic ...Check your topic");
                clientWeather.publish("save/Weather", messageClientOne);




            } catch (MqttException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    public void PublishForecast () throws MqttException, IOException, InterruptedException {

        clientForecast = new MqttClient("tcp://127.0.0.1:1883", clientID1);
        clientForecast.connect();
       // clientForecast.subscribe("saveLocation"); // om te checken wat er binnenkomt
       clientForecast.setCallback(this);
        MqttMessage messageClientTwo = new MqttMessage();
        messageClientTwo.setPayload(EntityUtils.toString(Forecast.entity)
                .getBytes());
        System.out.println("Reading Forecast API...please wait");
        System.out.println("Sending Data to chosen topic ...Check your topic");
        clientForecast.publish("save/Forecast", messageClientTwo);


    }



    @Override
    public void connectionLost(Throwable cause) {
        // TODO Auto-generated method stub

    }

    @Override
    public void messageArrived(String topic, MqttMessage message)
            throws Exception {
        /*String cord = new String(message.getPayload());
       //System.out.println(cord);
       clientForecast.publish("saveForecast", message);
        System.out.println("Getting latitude");
        String latidue = cord;
        System.out.println("Your latidue=" + latidue);*/

//'Latitude':'7.251'

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // TODO Auto-generated method stub

    }

}
