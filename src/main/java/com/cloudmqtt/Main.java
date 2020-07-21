package com.cloudmqtt;

import org.eclipse.paho.client.mqttv3.MqttException;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String args[]) throws MqttException, IOException, InterruptedException {
        Timer timer = new Timer(); // creating timer
        TimerTask task = new MyTask(); // creating timer task
        timer.schedule(task, 5000, 30000);


    }
    static class MyTask extends TimerTask {
        public void run() {
            System.out.println("*************************** [ STARTING YOUR TASK ] *******************************");
            PahoDemo pahoDemo = new PahoDemo();
            Weather.doHttpGet();
            try {
                pahoDemo.PublishWeather();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Forecast.doHttpGetTwo();
            try {
                pahoDemo.PublishForecast();
            } catch (MqttException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}




