package structural.flyweight;

public class EmailNotification implements Notification{
    private final String provider = "Email";
    @Override
    public void display(String timeStamp, String recipient) {
        System.out.println(provider + " notification sent to " + recipient + " at " + timeStamp);
    }
}
