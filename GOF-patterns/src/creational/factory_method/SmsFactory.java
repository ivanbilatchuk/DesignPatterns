package creational.factory_method;

public class SmsFactory extends NotificationFactory {
    public Notification create() { return new Sms(); }
}