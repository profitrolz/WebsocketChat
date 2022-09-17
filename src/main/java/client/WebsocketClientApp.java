package client;

import client.entity.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.util.Scanner;

public class WebsocketClientApp {

    public static void main(String[] args){
        WebsocketEndpoint simpleWebsocketEndpointEndpoint = new SimpleWebsocketClient().connect(new URI("ws://localhost:5555/chat"));
        Listener listener = ( websocketClient -> {
            websocketClient.start();
            ObjectMapper objectMapper = new ObjectMapper();
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                String str = in.nextLine();
                if (in.nextLine().equals("exit")) {
                    break;
                }
                websocketClient.sendMessage(objectMapper.writeValueAsString(new Message(, str)));
            }
        });
        listener.listen(simpleWebsocketEndpointEndpoint);
    }

}
