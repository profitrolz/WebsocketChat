package client.factory;

import client.WebsocketClient;

public interface AbstractWebsocketClientFactory {
    WebsocketClient getClient();
}
