package creational.factory_method;

public class Email implements Notification {
    public void send() {
        System.out.println("[Factory Method]Sending Email...");
    }
}
