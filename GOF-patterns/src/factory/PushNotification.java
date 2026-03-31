package factory;

public class PushNotification implements Notification{
    @Override
    public String getDetails() {
        return "Push Notification";
    }
}
