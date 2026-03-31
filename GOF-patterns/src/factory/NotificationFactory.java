package factory;

public class NotificationFactory {
    public static Notification createNotification(NotificationType type) {
        return switch (type) {
            case EMAIL -> new EmailNotification();
            case SMS -> new SmsNotification();
            case PUSH -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown type");
        };
    }
}
