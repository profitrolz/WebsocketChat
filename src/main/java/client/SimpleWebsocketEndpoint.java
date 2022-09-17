package client;



import javax.websocket.*;
import java.net.URI;
import java.util.Scanner;

@ClientEndpoint
public class SimpleWebsocketEndpoint extends AbstractWebsocketEndpoint {
    private Session session;

    public SimpleWebsocketEndpoint(MessageHandler messageHandler) {
        super(messageHandler);
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void start(URI endpointURI) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name: ");
        sender = in.nextLine();

        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @OnMessage
    public void onMessage(String message) {
        messageHandler.handleMessage(message);
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }

    public void sendMessage(String message) {
        this.session.getAsyncRemote().sendText(message);
    }
}
