package client;


import java.net.URI;

public class SimpleWebsocketClient implements WebsocketClient {

    @Override
    public WebsocketEndpoint connect(URI uri) {
        return new SimpleWebsocketEndpoint(System.out::println);
    }
}
