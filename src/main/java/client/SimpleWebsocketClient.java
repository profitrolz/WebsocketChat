package client;


import client.entity.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.Session;
import java.net.URI;
import java.util.Scanner;

public class SimpleWebsocketClient implements WebsocketClient {

    private final WebsocketEndpoint websocketEndpoint;
    private Session session;

    private String senderName;

    public SimpleWebsocketClient(URI endpointUri) {
        this.websocketEndpoint = new SimpleWebsocketEndpoint(System.out::println, endpointUri);
    }

    @Override
    public void connect() {
        this.session = websocketEndpoint.connect();
    }

    @Override
    public void start() {
        if(!session.isOpen()){
            throw new IllegalStateException("Session is not opened");
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name: ");
        senderName = in.nextLine();
        ObjectMapper objectMapper = new ObjectMapper();
        while (in.hasNext()) {
            String str = in.nextLine();
            if (in.nextLine().equals("exit")) {
                break;
            }
            try {
                session.getAsyncRemote().sendText(objectMapper.writeValueAsString(new Message(senderName, str)));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
