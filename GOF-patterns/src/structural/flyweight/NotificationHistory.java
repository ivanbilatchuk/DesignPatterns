package structural.flyweight;

import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;

public class NotificationHistory {
    private final List<Notification> history = new ArrayList<>();
    private final NotificationFactory factory;
    public NotificationHistory(NotificationFactory factory) {
        this.factory = factory;
    }
    public void record(NotificationType type, String time, String user) {
        Notification notification = factory.getNotification(type);
        notification.display(time, user);
        history.add(notification);
    }
}
