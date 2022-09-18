package client;



import javax.websocket.*;
import java.net.URI;
import java.util.Scanner;

@ClientEndpoint
public class SimpleWebsocketEndpoint extends AbstractWebsocketEndpoint {
    private Session session;
    private final URI endpointURI;

    public SimpleWebsocketEndpoint(MessageHandler messageHandler, URI endpointURI) {
        super(messageHandler);
        this.endpointURI = endpointURI;
    }

    protected void setSender(String sender) {
        this.sender = sender;
    }

    public void connect() {
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
