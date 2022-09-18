package client;

import client.entity.Message;
import client.factory.SimpleWebSocketClientFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class WebsocketClientApp {

    public static void main(String[] args){
        WebsocketClient websocketClient = new SimpleWebSocketClientFactory().getClient();
        websocketClient.connect();
        websocketClient.start();
    }

}
