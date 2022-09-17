package client;

@FunctionalInterface
public interface MessageHandler {
    void handleMessage(String message);
}
