package structural.bridge;

public class UrgentNotification extends Notification{
    public UrgentNotification(MessageSender s) {
        super(s);
    }
    public void notify(String msg) {
        sender.sendMessage("Urgent: " + msg);
    }
}
