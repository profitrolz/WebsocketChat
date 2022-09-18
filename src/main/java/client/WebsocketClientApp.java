package client;

import client.entity.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.util.Scanner;

public class WebsocketClientApp {

    public static void main(String[] args){
        WebsocketEndpoint simpleWebsocketEndpointEndpoint = new SimpleWebsocketClient().getWebsocketEndpoint();
        simpleWebsocketEndpointEndpoint.connect();

        Listener listener = ( websocketClient -> {
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
