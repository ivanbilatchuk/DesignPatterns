package behavioral.chain;

public class ChainPattern {
    public static abstract class NotificationHandler {
        private NotificationHandler next;
        public void setNext(NotificationHandler next) { this.next = next; }
        public void handle(String message, int severity) {
            if (next != null) next.handle(message, severity);
        }
    }

    public static class InfoHandler extends NotificationHandler {
        public void handle(String message, int severity) {
            if (severity == 1) System.out.println("INFO Notification: " + message);
            else super.handle(message, severity);
        }
    }

    public static class WarningHandler extends NotificationHandler {
        public void handle(String message, int severity) {
            if (severity == 2) System.out.println("WARNING Notification: " + message);
            else super.handle(message, severity);
        }
    }

    public static class ErrorHandler extends NotificationHandler {
        public void handle(String message, int severity) {
            if (severity == 3) System.out.println("ERROR Notification: " + message);
            else super.handle(message, severity);
        }
    }
}
