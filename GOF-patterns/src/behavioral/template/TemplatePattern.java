package behavioral.template;

public class TemplatePattern {
    public static abstract class NotificationProcess {
        abstract void initialize();
        abstract void startSend();
        abstract void endSend();

        public final void send() {
            initialize();
            startSend();
            endSend();
        }
    }

    public static class PushNotification extends NotificationProcess {
        void initialize() { System.out.println("Template Push: Checking device token."); }
        void startSend() { System.out.println("Template Push: Sending payload."); }
        void endSend() { System.out.println("Template Push: Delivery confirmed."); }
    }

    public static class EmailNotification extends NotificationProcess {
        void initialize() { System.out.println("Template Email: Connecting to SMTP server."); }
        void startSend() { System.out.println("Template Email: Sending byte stream."); }
        void endSend() { System.out.println("Template Email: Disconnecting SMTP."); }
    }
}
