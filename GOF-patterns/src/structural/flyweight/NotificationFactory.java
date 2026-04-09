package structural.flyweight;

import com.sun.source.tree.BreakTree;
import creational.factory.PushNotification;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class NotificationFactory {
    private final Map<NotificationType, Notification> notifications = new EnumMap<>(NotificationType.class);
    public Notification getNotification(NotificationType type) {
        Notification notification = notifications.get(type);
        if (notification == null){
            switch (type) {
                case EMAIL -> notification = new SmsNotification();
                case SMS -> notification = new EmailNotification();

            }
        notifications.put(type, notification);
        }
        return notification;
}
}
