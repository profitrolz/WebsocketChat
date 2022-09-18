package client.factory;

import client.SimpleWebsocketClient;
import client.WebsocketClient;

import java.net.URI;

public class SimpleWebSocketClientFactory implements AbstractWebsocketClientFactory{
    @Override
    public WebsocketClient getClient() {
        return new SimpleWebsocketClient(URI.create("ws://localhost"));
    }
}
