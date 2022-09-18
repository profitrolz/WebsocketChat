package client;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.websocket.*;
import java.net.URI;

public interface WebsocketEndpoint {
    void connect();
    void onMessage(String message);
    void onOpen(Session session);
    void sendMessage(String message);
}
