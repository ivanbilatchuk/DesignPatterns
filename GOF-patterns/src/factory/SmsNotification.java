package factory;

public class SmsNotification implements Notification{
    @Override
    public String getDetails() {
        return "SMS Notification";
    }
}
