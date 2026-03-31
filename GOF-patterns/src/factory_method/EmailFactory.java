package factory_method;

public class EmailFactory extends NotificationFactory {
    public Notification create() { return new Email(); }
}