package behavioral.chain;

public class WarningHandler extends NotificationHandler {
    @Override
    public void handle(String message, int severity) {
        if (severity == 2) {
            System.out.println("WARNING Notification: " + message);
        } else {
            super.handle(message, severity);
        }
    }
}
