/*
public static void PublishForecast () throws MqttException, IOException {

        IMqttClient client = new MqttClient("tcp://127.0.0.1:1883", "Sending");
        client.connect();
        //  client.subscribe("saveForecast"); // om te checken wat er binnenkomt
        MqttMessage messageClientTwo = new MqttMessage();
        messageClientTwo.setPayload(EntityUtils.toString(Forecast.entity)
        .getBytes());
        System.out.println("Reading Forecast API...please wait");
        System.out.println("Sending Data to chosen topic ...Check your topic");
        client.publish("saveWeather", messageClientTwo);





        }*/
