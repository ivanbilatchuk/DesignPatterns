package creational.factory_method;

public class Sms implements Notification {
    public void send() { System.out.println("[Factory Method] Sending SMS to mobile device..."); }
}