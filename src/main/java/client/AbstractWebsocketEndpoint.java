package client;


import javax.websocket.*;

public abstract class AbstractWebsocketEndpoint implements WebsocketEndpoint {
    protected final MessageHandler messageHandler;
    protected Session session;
    protected String sender;

    protected AbstractWebsocketEndpoint(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public abstract void start();

    @OnMessage
    public abstract void onMessage(String message);

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
    }

    public abstract void sendMessage(String message);
}
