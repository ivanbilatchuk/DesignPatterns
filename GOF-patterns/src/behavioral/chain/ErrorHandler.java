package behavioral.chain;

public class ErrorHandler extends NotificationHandler {
    @Override
    public void handle(String message, int severity) {
        if (severity == 3) {
            System.out.println("ERROR Notification: " + message);
        } else {
            super.handle(message, severity);
        }
    }
}
