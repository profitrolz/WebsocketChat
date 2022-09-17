package client;

import java.net.URI;

public interface WebsocketClient {
    WebsocketEndpoint connect(URI uri);
}
