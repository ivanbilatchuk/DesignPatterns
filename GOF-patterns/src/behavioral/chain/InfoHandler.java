package behavioral.chain;

public class InfoHandler extends NotificationHandler {
    @Override
    public void handle(String message, int severity) {
        if (severity == 1) {
            System.out.println("INFO Notification: " + message);
        } else {
            super.handle(message, severity);
        }
    }
}
