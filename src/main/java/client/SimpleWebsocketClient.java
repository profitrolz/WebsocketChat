package client;


import java.net.URI;

public class SimpleWebsocketClient implements WebsocketClient {

    @Override
    public WebsocketEndpoint getWebsocketEndpoint() {
        return new SimpleWebsocketEndpoint(System.out::println, URI.create(""));
    }
}
